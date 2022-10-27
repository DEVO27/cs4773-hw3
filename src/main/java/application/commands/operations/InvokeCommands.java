package application.commands.operations;

import application.commands.*;

/***
 * Handles the execution of all created commands
 */
public class InvokeCommands {
    private ICommand createRectangle;
    private ICommand createCircle;
    private ICommand selectShape;
    private ICommand moveShape;
    private ICommand drawShape;
    private ICommand changeColor;
    private ICommand deleteShape;
    private ICommand drawScene;
    private ICommand undo;

    public InvokeCommands(CreateRectangle rectangle) {
        this.createRectangle = rectangle;
        createRectangle.execute();
    }

    public InvokeCommands(CreateCircle circle) {
        this.createCircle = circle;
        createCircle.execute();
    }

    public InvokeCommands(SelectShape shape) {
        this.selectShape = shape;
    }

    public InvokeCommands(MoveShape shape) {
        this.moveShape = shape;
    }

    public InvokeCommands(DrawShape shape) {
        this.drawShape = shape;
        shape.execute();
    }

    public InvokeCommands(ChangeColor changeColor) {
        this.changeColor = changeColor;
    }

    public InvokeCommands(DrawScene drawScene) {
        this.drawScene = drawScene;
        drawScene.execute();
    }

    public InvokeCommands(UndoCommand undoCommand) {
        this.undo = undoCommand;
        undo.execute();
    }

    public InvokeCommands(DeleteShape deleteShape) {
        this.deleteShape = deleteShape;
    }

    public void executeSelect() {
        selectShape.execute();
    }

    public void executeCreateRectangle() {
        createRectangle.execute();
    }

    public void executeCreateCircle() {
        createCircle.execute();
    }

    public void executeMove() {
        moveShape.execute();
    }

    public void executeColor() {
        changeColor.execute();
    }

    public void executeDelete() {
        deleteShape.execute();
    }

    public void unExecuteMove() {
        moveShape.unExecute();
    }

    public void unExecuteColor() {
        changeColor.unExecute();
    }

    public void unExecuteSelect() {
        selectShape.unExecute();
    }

    public void unExecuteDelete() {
        deleteShape.unExecute();
    }

    public void unExecuteCreateCircle() {
        createCircle.unExecute();
    }

    public void unExecuteCreateRectangle() {
        createRectangle.unExecute();
    }
}
