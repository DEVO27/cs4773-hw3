package application.commands;

import application.model.Scene;
import application.shape.Colors;
import application.shape.Shape;

public class ChangeColor implements ICommand {
    private final Shape shape;
    private int index;
    private SelectShape selectShape;
    private Scene scene;
    private Colors color;

    public ChangeColor(Colors color, Scene scene, SelectShape selectShape) {
        this.selectShape = selectShape;
        this.scene = scene;
        this.index = selectShape.getIndex();
        this.shape = scene.getShape(index);
        this.color = color;
    }

    public ChangeColor(Shape shape) {
        this.shape = shape;
    }

    /***
     * Changes the current shape color IFF select was a previous command
     */
    @Override
    public void execute() {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            shape.saveToMemento();
            shape.setColor(Colors.valueOf(color.toString()));
        } else {
            System.out.println("no shape selected");
        }
    }

    /***
     * Sets current shape color to its last previous saved color
     */
    @Override
    public void unExecute() {
        shape.getMemento();
    }
}
