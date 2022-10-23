package application.commands.loader;

import application.commands.*;

import java.util.Stack;

public class Invoker {
    private ICommand createRectangle;
    private ICommand createCircle;
    private ICommand select;
    private ICommand move;
    private ICommand draw;
    private ICommand color;
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

    public Invoker(ChangeColor color) {
        this.color = color;
        commands.push(color);
        color.execute();
    }

    public Invoker(DrawSceneShape drawScene) {
        this.drawScene = drawScene;
        drawScene.execute();
    }

    public void Undo() {
        commands.pop().unExecute();
    }
}
