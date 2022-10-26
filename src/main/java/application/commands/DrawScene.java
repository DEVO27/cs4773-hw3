package application.commands;

import application.shape.Shape;

import java.util.List;

public class DrawScene implements ICommand {
    private List<Shape> shapes;

    public DrawScene(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public void execute() {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }

    @Override
    public void unExecute() {

    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }
}
