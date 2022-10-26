package application.commands;

import application.model.Scene;
import application.shape.Colors;
import application.shape.Shape;

public class ChangeColor implements ICommand {
    private Shape shape;
    private Colors color;
    private SelectShape selectShape;

    public ChangeColor(Shape shape, Colors color,SelectShape selectShape) {
        this.shape = shape;
        this.color = color;
        this.selectShape = selectShape;
    }

    public ChangeColor(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            shape.saveToMemento();
            shape.setColor(Colors.valueOf(color.toString()));
        } else {
            System.out.println("no shape selected");
        }
    }

    @Override
    public void unExecute() {
        shape.getMemento();
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
