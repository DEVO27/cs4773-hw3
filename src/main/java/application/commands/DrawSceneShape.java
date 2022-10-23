package application.commands;

import application.shapes.Shape;

import java.util.List;

/**
 * The type Draw scene shape.
 */
public class DrawSceneShape implements ICommand {
    /**
     * The Shapes.
     */
    List<Shape> shapes;

    /**
     * Instantiates a new Draw scene shape.
     *
     * @param shapes the shapes
     */
    public DrawSceneShape(List<Shape> shapes) {
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


}
