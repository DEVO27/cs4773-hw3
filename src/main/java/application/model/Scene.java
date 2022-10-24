package application.model;

import application.shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public void saveToMemento() {
        mementoStack.push(new Scene.Memento(getSavedShapes()));
    }

    public Stack<Memento> getMementoStack() {
        return mementoStack;
    }

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
