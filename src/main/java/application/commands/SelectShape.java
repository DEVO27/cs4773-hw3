package application.commands;

import application.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Select shape.
 */
public class SelectShape implements ICommand {
    private List<Shape> shapes = new ArrayList<>();
    private Shape curShape;
    private int index;

    /**
     * Instantiates a new Select shape.
     *
     * @param index the index
     */
    public SelectShape(int index) {
        this.index = index - 1;
    }

    /**
     * Set's local shape to current index inside list
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void execute() throws IndexOutOfBoundsException {
        setCurShape(shapes.get(getIndex()));
    }

    @Override
    public void unExecute() {
    }

    /**
     * Gets shapes.
     *
     * @return the shapes
     */
    public List<Shape> getShapes() {
        return shapes;
    }

    /**
     * Sets shapes.
     *
     * @param shapes the shapes
     */
    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    /**
     * Gets cur shape.
     *
     * @return the cur shape
     */
    public Shape getCurShape() {
        return curShape;
    }

    /**
     * Sets cur shape.
     *
     * @param curShape the cur shape
     */
    public void setCurShape(Shape curShape) {
        this.curShape = curShape;
    }

    /**
     * Gets index.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets index.
     *
     * @param index the index
     */
    public void setIndex(int index) {
        this.index = index - 1;
    }
}
