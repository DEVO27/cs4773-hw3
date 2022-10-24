package application.model;

import application.shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CareTaker {
    List<Shape> savedShapes = new ArrayList<>();
    Stack<Memento> mementoStack = new Stack<>();

    public void addShape(Shape shape) {
        savedShapes.add(shape);
    }


    public Shape getShape(int index) {
        return savedShapes.get(index);
    }

    public void saveToMemento() {
        mementoStack.push(new CareTaker.Memento(savedShapes));
    }

    public void getMementoStack() {
        savedShapes = mementoStack.pop().getShapeList();
    }

    public void setShape(Shape shape, int index) {
        savedShapes.set(index, shape);
    }

    public class Memento {
        List<Shape> shapeList;

        public Memento(List<Shape> shapeList) {
            this.shapeList = shapeList;
        }

        public List<Shape> getShapeList() {
            return shapeList;
        }
    }


    public void setMementoStack(Stack<Memento> mementoStack) {
        this.mementoStack = mementoStack;
    }
}
