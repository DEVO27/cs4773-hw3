package application.commands.interpreter;

import application.commands.*;
import application.shapes.Colors;
import application.shapes.Shape;

import java.util.Stack;

public class ProcessCommands {
    private CreateRectangle createRectangle;
    private application.model.Scene scene;
    private final SelectShape selectShape;
    private InvokeCommands invokeCommands;
    private Stack<String> invokerStack;
    private CreateCircle createCircle;
    private ChangeColor changeColor;
    private UndoCommand undoCommand;

    public ProcessCommands() {
        this.scene = new application.model.Scene();
        this.invokerStack = new Stack<>();
        this.selectShape = new SelectShape(0);
    }

    public void choice(String command, String[] parse, Stack<String> inputCmd) {
        invokerStack = inputCmd;
        switch (command) {
            case "CREATE RECTANGLE" -> rectangle(parse);
            case "CREATE CIRCLE" -> circle(parse);
            case "SELECT" -> select(parse);
            case "MOVE" -> move(parse);
            case "DRAW" -> loadDraw();
            case "DRAWSCENE" -> loadDrawScene();
            case "COLOR" -> loadColor(parse);
            case "UNDO" -> loadUndo();
            case "DELETE" -> delete();
        }
    }

    public void rectangle(String[] cmd) {
        int x = Integer.parseInt(cmd[2]);
        int y = Integer.parseInt(cmd[3]);
        createRectangle = new CreateRectangle(x, y);
        invokeCommands = new InvokeCommands(createRectangle);
        Shape shape = createRectangle.getShape();
        scene.addShape(createRectangle.getShape());
        selectShape.setActive(Boolean.FALSE);
    }

    public void circle(String[] cmd) {
        int radius = Integer.parseInt(cmd[2]);
        createCircle = new CreateCircle(radius);
        invokeCommands = new InvokeCommands(createCircle);
        scene.addShape(createCircle.getShape());
        selectShape.setActive(Boolean.FALSE);
    }

    public void select(String[] cmd) {
        int index = Integer.parseInt(cmd[1]) - 1;
        if (index < scene.getSavedShapes().size()) {
            selectShape.setIndex(index);
            invokeCommands = new InvokeCommands(selectShape);
            scene.setCurShape(scene.getShape(index));
            selectShape.setActive(Boolean.TRUE);
        } else {
            System.out.println("ERROR: invalid shape for SELECT");
        }
    }

    public void move(String[] cmd) {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            int x = Integer.parseInt(cmd[1]);
            int y = Integer.parseInt(cmd[2]);
            int index = selectShape.getIndex();
            invokeCommands = new InvokeCommands(new MoveShape(scene.getShape(index), x, y));
            scene.setShape(scene.getShape(index), index);
        } else {
            System.out.println("no shape selected");
        }
    }

    public void loadDraw() {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            int index = selectShape.getIndex();
            invokeCommands = new InvokeCommands(new DrawShape(scene.getShape(index)));
        } else {
            System.out.println("no shape selected");
        }
    }

    public void loadColor(String[] cmd) {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            int index = selectShape.getIndex();
            changeColor = new ChangeColor(scene.getShape(index), Colors.valueOf(cmd[1]));
            invokeCommands = new InvokeCommands(changeColor);
            invokeCommands.changeColor();
        } else {
            invokeCommands = new InvokeCommands(new SelectShape(0));
        }
    }

    public void loadDrawScene() {
        invokeCommands = new InvokeCommands(new DrawSceneShape(scene.getSavedShapes()));
    }

    public void delete() {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            int curIndex = selectShape.getIndex();
            DeleteShape deleteShape = new DeleteShape(curIndex, scene);
            invokeCommands = new InvokeCommands(deleteShape);
            invokeCommands.deleteShape();
        }
        selectShape.setActive(Boolean.FALSE);
    }

    public void loadUndo() {
        undoCommand = new UndoCommand(invokerStack.pop(), scene, selectShape);
        invokeCommands = new InvokeCommands(undoCommand);
        scene = undoCommand.getSceneShape();
    }
}
