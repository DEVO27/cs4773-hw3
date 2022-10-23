package application.shapes;

import java.util.LinkedList;

/**
 * The type Circle.
 */
public class Circle extends Shape {
    private int radius;

    /**
     * Instantiates a new Circle.
     *
     * @param radius the radius
     */
    public Circle(int radius) {
        this.radius = radius;
        super.setXCoordinate(0);
        super.setYCoordinate(0);
        super.setColor(Colors.Blue);
        super.setColorHistory(new LinkedList<>());
        super.setCoordinateHistory(new LinkedList<>());
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

    @Override
    public String toString() {
        return "Circle, %s Radius: %d".formatted(super.toString(), getRadius());
    }
}
