package application.commands.interpreter;

import application.commands.*;

import java.util.Stack;

public class Invoker {
    private ICommand createRectangle;
    private ICommand createCircle;
    private ICommand select;
    private ICommand move;
    private ICommand draw;
    private ICommand changeColor;
    private ICommand delete;
    private ICommand drawScene;
    private ICommand undo;
    private final Stack<ICommand> commands = new Stack<>();

    public Invoker(CreateRectangle rectangle) {
        this.createRectangle = rectangle;
        createRectangle.execute();
    }

    public Invoker(CreateCircle circle) {
        this.createCircle = circle;
        createCircle.execute();
    }

    public Invoker(SelectShape shape) {
        this.select = shape;
        try {
            select.execute();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR: invalid shape for SELECT");
        }
    }

    public Invoker(MoveShape shape) {
        this.move = shape;
        move.execute();
    }

    public Invoker(DrawShape shape) {
        this.draw = shape;
        shape.execute();
    }

    public Invoker(ChangeColor changeColor) {
        this.changeColor = changeColor;
    }

    public Invoker(DrawSceneShape drawScene) {
        this.drawScene = drawScene;
        drawScene.execute();
    }

    public Invoker(UndoCommand undoCommand) {
        this.undo = undoCommand;
        undo.execute();
    }

    public void changeColor() {
        changeColor.execute();
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

}
