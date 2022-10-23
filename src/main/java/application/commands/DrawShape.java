package application.commands;

import application.shapes.Shape;

/**
 * The type Draw shape.
 */
public class DrawShape implements ICommand {
    private Shape shape;

    /**
     * Instantiates a new Draw shape.
     *
     * @param shape the shape
     */
    public DrawShape(Shape shape) {
        this.shape = shape;
    }

    /***
     * print's current shape
     */
    @Override
    public void execute() {
        System.out.println(getShape());
    }

    /***
     * No output to stdout for undo operation
     */
    @Override
    public void unExecute() {

    }

    /**
     * Gets shape.
     *
     * @return the shape
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * Sets shape.
     *
     * @param shape the shape
     */
    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
