package application.shape;

import java.util.Stack;

public abstract class Shape {
    private final Stack<Memento> mementoStack = new Stack<>();
    private Colors color;
    private int xCoordinate;
    private int yCoordinate;

    public class Memento {
        private final Colors colors;
        private final int xCoordinate;
        private final int yCoordinate;

        public Memento(Colors colors, int xCoordinate, int yCoordinate) {
            this.colors = color;
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
        }

        public Colors getColors() {
            return colors;
        }

        public int getXCoordinate() {
            return xCoordinate;
        }

        public int getYCoordinate() {
            return yCoordinate;
        }
    }

    public int getXCoordinate() {
        return xCoordinate;
    }


    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void saveToMemento() {
        mementoStack.push(new Memento(getColor(), getXCoordinate(), getYCoordinate()));
    }

    public void getMemento() {
        Memento memento = mementoStack.pop();
        setColor(memento.getColors());
        setYCoordinate(memento.getYCoordinate());
        setXCoordinate(memento.getXCoordinate());
    }

    public Stack<Memento> getMementoStack() {
        return mementoStack;
    }

    @Override
    public String toString() {
        return "Color: %s, Coordinates: (%d %d),".formatted(getColor().toString(), getXCoordinate(), getYCoordinate());
    }
}
