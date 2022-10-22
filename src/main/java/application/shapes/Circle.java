package application.shapes;

public class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
        super.setOrigin(new int[]{0, 0});
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
