package application.shape;

/**
 * The type Rectangle.
 */
public class Rectangle extends Shape {
    private int width;
    private int height;

    /**
     * Instantiates a new Rectangle.
     *
     * @param width  the width
     * @param height the height
     */
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        super.setXCoordinate(0);
        super.setYCoordinate(0);
        super.setColor(Colors.Red);
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets width.
     *
     * @param width the width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle, %s Width: %d, Height: %d".formatted(super.toString(), getWidth(), getHeight());
    }
}
