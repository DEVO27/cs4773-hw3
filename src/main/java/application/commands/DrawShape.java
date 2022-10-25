package application.commands;

import application.shape.Shape;

public class DrawShape implements ICommand {
    private Shape shape;

    public DrawShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        System.out.println(getShape());
    }

    @Override
    public void unExecute() {

    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
