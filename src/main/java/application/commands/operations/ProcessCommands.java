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
        selectShape.setNewIndex(index);
        selectShape.setScene(scene);
        invokeCommands = new InvokeCommands(selectShape);
        invokeCommands.executeSelect();
    }

    public void moveShape(String[] input) {
        int x = Integer.parseInt(input[1]);
        int y = Integer.parseInt(input[2]);
        invokeCommands = new InvokeCommands(new MoveShape(selectShape, scene, x, y));
        invokeCommands.executeMove();
    }

    public void drawShape() {
        invokeCommands = new InvokeCommands(new DrawShape(scene, selectShape));
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
