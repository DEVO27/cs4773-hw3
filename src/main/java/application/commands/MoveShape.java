package application.commands;

import application.model.Scene;
import application.shape.Shape;

public class MoveShape implements ICommand {
    private Scene scene;
    private SelectShape selectShape;
    private Shape shape;
    private int index;
    private int x;
    private int y;

    public MoveShape(SelectShape selected, Scene scene, int x, int y) {
        this.scene = scene;
        this.selectShape = selected;
        this.index = selectShape.getIndex();
        this.shape = scene.getShape(index);
        this.x = x;
        this.y = y;
    }

    public MoveShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void execute() {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            shape.saveToMemento();
            shape.setXCoordinate(getX());
            shape.setYCoordinate(getY());
            scene.setShape(scene.getShape(index), index);
        }
        else {
            System.out.println("No shape selected");
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
