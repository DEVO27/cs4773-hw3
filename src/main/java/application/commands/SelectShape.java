package application.commands;

import application.model.Scene;

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

    /***
     * Saves the new index into the stack
     */
    @Override
    public void execute() {
        if (index < scene.getSavedShapes().size() && newIndex < scene.getSavedShapes().size()) {
            saveToMemento();
            setIndex(newIndex);
            scene.setCurShape(scene.getShape(index));
            setActive(Boolean.TRUE);
        } else {
            System.out.println("ERROR: invalid shape for SELECT");
        }
    }

    /***
     * gets and sets the last saved index in the stack
     * to be the current index
     */
    @Override
    public void unExecute() {
        if (!indexStack.isEmpty() && index > 0) {
            getMemento();
        } else {
            System.out.println("No Shape");
        }
    }

    /**
     * Saves new index to the stack
     */
    public void saveToMemento() {
        this.indexStack.push(new Memento(getIndex()));
    }

    /***
     * Sets previous index from stack
     */
    public void getMemento() {
        int temp = indexStack.pop().getIndex();
        setIndex(temp);
    }

    public class Memento {
        private final int index;

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

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

}
