package application.commands;

import application.shapes.Colors;
import application.shapes.Shape;

/**
 * The type Change color.
 */
public class ChangeColor implements ICommand {
    private final Shape shape;
    /**
     * The Color.
     */
    Colors color;

    /**
     * Instantiates a new Change color.
     *
     * @param shape the shape
     * @param color the color
     */
    public ChangeColor(Shape shape, Colors color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public void execute() {
        shape.setColor(Colors.valueOf(color.toString()));
    }

    @Override
    public void unExecute() {
        shape.getColorHistory().add(shape.getColor());
        shape.setColor(Colors.valueOf(color.toString()));
    }
}
