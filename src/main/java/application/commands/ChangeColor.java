package application.commands;

import application.shape.Colors;
import application.shape.Shape;

/**
 * The type Change color.
 */
public class ChangeColor implements ICommand {
    private Shape shape;
    /**
     * The Color.
     */
    private Colors color;

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

    public ChangeColor(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        shape.saveToMemento();
        shape.setColor(Colors.valueOf(color.toString()));
    }

    @Override
    public void unExecute() {
        shape.getMemento();
    }
}
