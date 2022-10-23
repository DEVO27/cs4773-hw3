package application.shapes;

import java.util.Queue;

/**
 * The type Shape.
 */
public abstract class Shape {
    private Queue<Colors> colorHistory;
    private Queue<Integer> coordinateHistory;
    private Colors color;
    private int xCoordinate;
    private int yCoordinate;

    /**
     * Gets x coordinate.
     *
     * @return the x coordinate
     */
    public int getXCoordinate() {
        return xCoordinate;
    }


    /**
     * Sets x coordinate.
     *
     * @param xCoordinate the x coordinate
     */
    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    /**
     * Gets y coordinate.
     *
     * @return the y coordinate
     */
    public int getYCoordinate() {
        return yCoordinate;
    }

    /**
     * Sets y coordinate.
     *
     * @param yCoordinate the y coordinate
     */
    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Colors getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(Colors color) {
        this.color = color;
    }

    /**
     * Gets color history.
     *
     * @return the color history
     */
    public Queue<Colors> getColorHistory() {
        return colorHistory;
    }

    /**
     * Sets color history.
     *
     * @param colorHistory the color history
     */
    public void setColorHistory(Queue<Colors> colorHistory) {
        this.colorHistory = colorHistory;
    }

    /**
     * Gets coordinate history.
     *
     * @return the coordinate history
     */
    public Queue<Integer> getCoordinateHistory() {
        return coordinateHistory;
    }

    /**
     * Sets coordinate history.
     *
     * @param coordinateHistory the coordinate history
     */
    public void setCoordinateHistory(Queue<Integer> coordinateHistory) {
        this.coordinateHistory = coordinateHistory;
    }

    @Override
    public String toString() {
        return "Color: %s, Origin: (%d %d),".formatted(getColor().toString(), getXCoordinate(), getYCoordinate());
    }
}
