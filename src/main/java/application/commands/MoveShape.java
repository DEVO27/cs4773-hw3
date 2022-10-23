package application.commands;

import application.shapes.Shape;

/**
 * The type Move shape.
 */
public class MoveShape implements ICommand {
    private Shape shape;
    private int x;
    private int y;

    /**
     * Instantiates a new Move shape.
     *
     * @param shape the shape
     * @param x     the x
     * @param y     the y
     */
    public MoveShape(Shape shape, int x, int y) {
        this.shape = shape;
        this.x = x;
        this.y = y;
    }

    /***
     * Stores current coordinates in queue
     * assign current values
     */
    @Override
    public void execute() {
        shape.getCoordinateHistory().add(getX());
        shape.getCoordinateHistory().add(getY());
        shape.setXCoordinate(getX());
        shape.setYCoordinate(getY());
    }

    /***
     * return's the last two entered values
     * prints error if no values are present
     */
    @Override
    public void unExecute() {
        if (shape.getCoordinateHistory().size() >= 2) {
            shape.setXCoordinate(shape.getCoordinateHistory().remove());
            shape.setYCoordinate(shape.getCoordinateHistory().remove());
        } else {
            System.out.println("Cannot Undo");
        }
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
