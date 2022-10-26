package application.commands.operations;

import application.commands.*;
import application.shape.Colors;

import java.util.Stack;

public class ProcessCommands {
    private application.model.Scene scene;
    private SelectShape selectShape;
    private InvokeCommands invokeCommands;
    private Stack<String> invokerStack;
    private UndoCommand undoCommand;

    public ProcessCommands() {
        this.scene = new application.model.Scene();
        this.invokerStack = new Stack<>();
        this.selectShape = new SelectShape(-1);
    }

    public void choice(String command, String[] parse, Stack<String> inputCmd) {
        invokerStack = inputCmd;
        switch (command) {
            case "CREATE RECTANGLE" -> createRectangle(parse);
            case "CREATE CIRCLE" -> createCircle(parse);
            case "SELECT" -> selectShape(parse);
            case "MOVE" -> moveShape(parse);
            case "DRAW" -> drawShape();
            case "DRAWSCENE" -> drawScene();
            case "COLOR" -> changeColor(parse);
            case "UNDO" -> undoCommand();
            case "DELETE" -> deleteShape();
            default -> System.out.println("Invalid Command");
        }
    }

    public void createRectangle(String[] input) {
        CreateRectangle createRectangle = new CreateRectangle(input);
        invokeCommands = new InvokeCommands(createRectangle);
        scene.addShape(createRectangle.getShape());
        selectShape.setActive(Boolean.FALSE);
    }

    public void createCircle(String[] input) {
        CreateCircle createCircle = new CreateCircle(input);
        invokeCommands = new InvokeCommands(createCircle);
        scene.addShape(createCircle.getShape());
        selectShape.setActive(Boolean.FALSE);
    }

    public void selectShape(String[] input) {
        int index = Integer.parseInt(input[1]) - 1;
        if (index < scene.getSavedShapes().size()) {
            selectShape.setNewIndex(index);
            invokeCommands = new InvokeCommands(selectShape);
            invokeCommands.executeSelect();
            scene.setCurShape(scene.getShape(index));
            selectShape.setActive(Boolean.TRUE);
        } else {
            System.out.println("ERROR: invalid shape for SELECT");
        }
    }

    public void moveShape(String[] input) {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            int x = Integer.parseInt(input[1]);
            int y = Integer.parseInt(input[2]);
            int index = selectShape.getIndex();
            invokeCommands = new InvokeCommands(new MoveShape(scene.getShape(index), x, y));
            invokeCommands.executeMove();
            scene.setShape(scene.getShape(index), index);
        } else {
            System.out.println("no shape selected");
        }
    }

    public void drawShape() {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            int index = selectShape.getIndex();
            invokeCommands = new InvokeCommands(new DrawShape(scene.getShape(index)));
        } else {
            System.out.println("no shape selected");
        }
    }

    public void changeColor(String[] cmd) {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            int index = selectShape.getIndex();
            ChangeColor changeColor = new ChangeColor(scene.getShape(index), Colors.valueOf(cmd[1]));
            invokeCommands = new InvokeCommands(changeColor);
            invokeCommands.executeColor();
        } else {
            invokeCommands = new InvokeCommands(new SelectShape(0));
        }
    }

    public void drawScene() {
        invokeCommands = new InvokeCommands(new DrawScene(scene.getSavedShapes()));
    }

    public void deleteShape() {
        int curIndex = selectShape.getIndex();
        DeleteShape deleteShape = new DeleteShape(selectShape, scene);
        invokeCommands = new InvokeCommands(deleteShape);
        invokeCommands.executeDelete();
        selectShape = deleteShape.getSelectShape();
    }

    public void undoCommand() {
        undoCommand = new UndoCommand(invokerStack.pop(), scene, selectShape);
        invokeCommands = new InvokeCommands(undoCommand);
        selectShape = undoCommand.getSelectShape();
        scene = undoCommand.getSceneShape();
    }
}
