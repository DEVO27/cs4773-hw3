package application.commands;

import application.shapes.Circle;
import application.shapes.Shape;

/**
 * The type Create circle.
 */
public class CreateCircle implements ICommand {
    private Shape shape;
    private int radius;

    /**
     * Instantiates a new Create circle.
     *
     * @param radius the radius
     */
    public CreateCircle(int radius) {
        this.radius = radius;
    }

    @Override
    public void execute() {
        this.shape = new Circle(getRadius());
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
     * Gets radius.
     *
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Sets radius.
     *
     * @param radius the radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
