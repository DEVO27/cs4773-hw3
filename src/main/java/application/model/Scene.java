package application.model;

import application.shape.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * Class tracks and stores previous list of shapes in the
 * saved shape array
 */
public class Scene {
    private List<Shape> savedShapes = new ArrayList<>();
    private Stack<Memento> mementoStack = new Stack<>();
    private Shape curShape;

    public void addShape(Shape shape) {
        savedShapes.add(shape);
    }

    public void setCurShape(Shape curShape) {
        this.curShape = curShape;
    }

    public Shape getShape(int index) {
        return savedShapes.get(index);
    }

    /***
     * Pushes the current list of shapes onto the stack
     */
    public void saveToMemento() {
        mementoStack.push(new Scene.Memento(getSavedShapes()));
    }

    public Stack<Memento> getMementoStack() {
        return mementoStack;
    }

    /***
     * Set's the current list of shapes to the last previous saved list
     */
    public void getMemento() {
        setSavedShapes(mementoStack.pop().shapeList);
    }

    public void setMementoStack(Stack<Memento> mementoStack) {
        this.mementoStack = mementoStack;
    }

    public Shape getCurShape() {
        return curShape;
    }

    public void setShape(Shape shape, int index) {
        savedShapes.set(index, shape);
    }

    public List<Shape> getSavedShapes() {
        return savedShapes;
    }

    public void setSavedShapes(List<Shape> savedShapes) {
        this.savedShapes = savedShapes;
    }


    /***
     * Assigns and saves previous content within the stack
     * containing the list of shapes
     */
    public class Memento {
        List<Shape> shapeList;

        public Memento(List<Shape> shapeList) {
            this.shapeList = new ArrayList<>();
            this.shapeList.addAll(shapeList);
        }

        public List<Shape> getShapeList() {
            return shapeList;
        }
    }


}
