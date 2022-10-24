package application.commands;

import application.shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The type Select shape.
 */
public class SelectShape implements ICommand {
    private Boolean active;
    private List<Shape> shapes;
    private Stack previousIndex;
    private Shape curShape;
    private int index;

    /**
     * Instantiates a new Select shape.
     *
     * @param index the index
     */
    public SelectShape(int index) {
        this.index = index - 1;
        this.previousIndex = new Stack<>();
        this.shapes = new ArrayList<>();
    }

    /**
     * Set's local shape to current index inside list
     *
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void execute() throws IndexOutOfBoundsException {
        previousIndex.push(getIndex());
        setCurShape(shapes.get(getIndex()));
    }

    @Override
    public void unExecute() {
        if (!getPreviousIndex().isEmpty()) {
            setCurShape(shapes.get((int) getPreviousIndex().pop()));
        } else {
            System.out.println("No Shape");
        }
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

    public Stack getPreviousIndex() {
        return previousIndex;
    }

    public void setPreviousIndex(Stack previousIndex) {
        this.previousIndex = previousIndex;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
