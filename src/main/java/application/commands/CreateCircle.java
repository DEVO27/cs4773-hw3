package application.commands;

import application.shape.Circle;
import application.shape.Shape;

public class CreateCircle implements ICommand {
    private Shape shape;
    private int radius;

    public CreateCircle(String[] input) {
        this.radius = Integer.parseInt(input[2]);
    }

    @Override
    public void execute() {
        this.shape = new Circle(getRadius());
    }

    @Override
    public void unExecute() {
        this.shape = null;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
