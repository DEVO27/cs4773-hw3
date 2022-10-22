package application.shapes;

public class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
        super.setXCoordinate(0);
        super.setYCoordinate(0);
        super.setColor(Colors.Blue);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle, %s, Radius: %d".formatted(super.toString(), getRadius());
    }
}
