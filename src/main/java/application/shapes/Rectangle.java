package application.shapes;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
        super.setXCoordinate(0);
        super.setYCoordinate(0);
        super.setColor(Colors.Red);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle, %s Width: %d, Height: %d".formatted(super.toString(), getWidth(), getHeight());
    }
}
