package application.commands.interpreter;

import application.commands.*;

public class InvokeCommands {
    private ICommand createRectangle;
    private ICommand createCircle;
    private ICommand select;
    private ICommand move;
    private ICommand draw;
    private ICommand changeColor;
    private ICommand delete;
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
        this.select = shape;
        try {
            select.execute();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR: invalid shape for SELECT");
        }
    }

    public InvokeCommands(MoveShape shape) {
        this.move = shape;
        move.execute();
    }

    public InvokeCommands(DrawShape shape) {
        this.draw = shape;
        shape.execute();
    }

    public InvokeCommands(ChangeColor changeColor) {
        this.changeColor = changeColor;
    }

    public InvokeCommands(DrawSceneShape drawScene) {
        this.drawScene = drawScene;
        drawScene.execute();
    }

    public InvokeCommands(UndoCommand undoCommand) {
        this.undo = undoCommand;
        undo.execute();
    }

    public InvokeCommands(DeleteShape deleteShape){
        this.delete = deleteShape;
    }

    public void changeColor() {
        changeColor.execute();
    }

    public void deleteShape() {
        delete.execute();
    }

    public void undoMove() {
        move.unExecute();
    }

    public void undoColor() {
        changeColor.unExecute();
    }

    public void undoSelect() {
        select.unExecute();
    }
    public void undoDeleteShape() {
        delete.unExecute();
    }





}
