package application.commands;

import application.model.Scene;

import java.util.Arrays;
import java.util.Stack;

public class SelectShape implements ICommand {
    private Stack<Memento> indexStack = new Stack<>();
    private Scene scene;
    private Boolean active;
    private int index;
    private int newIndex;

    public SelectShape(int index) {
        this.index = index;
    }

    @Override
    public void execute() throws IndexOutOfBoundsException {
        if (index < scene.getSavedShapes().size() && index >= 0) {
            saveToMemento();
            setIndex(newIndex);
            scene.setCurShape(scene.getShape(index));
            setActive(Boolean.TRUE);
        } else {
            System.out.println("ERROR: invalid shape for SELECT");
        }
    }

    @Override
    public void unExecute() {
        if (!indexStack.isEmpty() && index > 0){
            getMemento();
        } else {
            System.out.println("No Shape");
        }
    }

    public void saveToMemento() {
        this.indexStack.push(new Memento(getIndex()));
    }

    public void getMemento() {
        int temp = indexStack.pop().getIndex();
        setIndex(temp);
    }

    public class Memento {
        private int index;

        public Memento(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Stack<Memento> getIndexStack() {
        return indexStack;
    }

    public void setIndexStack(Stack<Memento> indexStack) {
        this.indexStack = indexStack;
    }

    public int getNewIndex() {
        return newIndex;
    }

    public void setNewIndex(int newIndex) {
        this.newIndex = newIndex;
    }

    public Scene getScene() {return scene;}

    public void setScene(Scene scene) {this.scene = scene;}

}
