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

    /***
     * Selects the proper command to be created and navigates to its respective method
     * @param command
     * @param parse
     * @param inputCmd
     */
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

    /***
     * Creates and executes createRectangle command
     * @param input
     */
    public void createRectangle(String[] input) {
        CreateRectangle createRectangle = new CreateRectangle(input);
        invokeCommands = new InvokeCommands(createRectangle);
        scene.addShape(createRectangle.getShape());
        selectShape.setActive(Boolean.FALSE);
    }

    /**
     * Creates and executes createCircle command
     *
     * @param input
     */
    public void createCircle(String[] input) {
        CreateCircle createCircle = new CreateCircle(input);
        invokeCommands = new InvokeCommands(createCircle);
        scene.addShape(createCircle.getShape());
        selectShape.setActive(Boolean.FALSE);
    }

    /***
     * Creates and executes selectShape command
     * @param input
     */
    public void selectShape(String[] input) {
        int index = Integer.parseInt(input[1]) - 1;
        selectShape.setNewIndex(index);
        selectShape.setScene(scene);
        invokeCommands = new InvokeCommands(selectShape);
        invokeCommands.executeSelect();
    }

    /***
     * Creates and executes moveShape command
     * @param input
     */
    public void moveShape(String[] input) {
        int x = Integer.parseInt(input[1]);
        int y = Integer.parseInt(input[2]);
        invokeCommands = new InvokeCommands(new MoveShape(selectShape, scene, x, y));
        invokeCommands.executeMove();
    }

    /***
     * Creates and executes printing of a shape command
     */
    public void drawShape() {
        invokeCommands = new InvokeCommands(new DrawShape(scene, selectShape));
    }

    /***
     * Creates and executes moveShape command
     * @param input
     */
    public void changeColor(String[] input) {
        ChangeColor changeColor = new ChangeColor(Colors.valueOf(input[1]), scene, selectShape);
        invokeCommands = new InvokeCommands(changeColor);
        invokeCommands.executeColor();
    }

    /***
     * Creates and executes drawScene (Array of Shapes) command
     */
    public void drawScene() {
        invokeCommands = new InvokeCommands(new DrawScene(scene.getSavedShapes()));
    }

    /***
     * Creates and executes deleting of specific shape command
     */
    public void deleteShape() {
        DeleteShape deleteShape = new DeleteShape(selectShape, scene);
        invokeCommands = new InvokeCommands(deleteShape);
        invokeCommands.executeDelete();
        selectShape = deleteShape.getSelectShape();
    }

    /***
     * Creates and executes all undo operations
     */
    public void undoCommand() {
        undoCommand = new UndoCommand(invokerStack.pop(), scene, selectShape);
        invokeCommands = new InvokeCommands(undoCommand);
        selectShape = undoCommand.getSelectShape();
        scene = undoCommand.getSceneShape();
    }
}
