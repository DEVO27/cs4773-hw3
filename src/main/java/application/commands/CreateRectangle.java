package application.commands;

import application.shapes.Rectangle;
import application.shapes.Shape;

/**
 * The type Create rectangle.
 */
public class CreateRectangle implements ICommand {
    private Shape shape;
    private int x;
    private int y;

    /**
     * Instantiates a new Create rectangle.
     *
     * @param x the x
     * @param y the y
     */
    public CreateRectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        this.shape = new Rectangle(getX(), getY());
    }

    @Override
    public void unExecute() {
        this.shape = null;
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

    /**
     * Gets x.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(int y) {
        this.y = y;
    }
}
