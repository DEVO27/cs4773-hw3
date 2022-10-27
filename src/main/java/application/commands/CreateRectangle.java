package application.commands;

import application.shape.Rectangle;
import application.shape.Shape;

public class CreateRectangle implements ICommand {
    private Shape shape;
    private int x;
    private int y;

    public CreateRectangle(String[] input) {
        this.x = Integer.parseInt(input[2]);
        this.y = Integer.parseInt(input[3]);
    }

    /***
     * Creates a new shape
     */
    @Override
    public void execute() {
        this.shape = new Rectangle(getX(), getY());
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
