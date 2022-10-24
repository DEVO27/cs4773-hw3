package application.commands;

import java.util.Stack;

public class SelectShape implements ICommand {
    private Stack<Memento> indexStack = new Stack<>();
    private Boolean active;
    private int index;

    public SelectShape(int index) {
        this.index = index;
    }

    @Override
    public void execute() throws IndexOutOfBoundsException {
        saveToMemento();
        setIndex(index);
    }

    @Override
    public void unExecute() {
        if (!indexStack.isEmpty()){
            getMemento();
        } else {
            System.out.println("No Shape");
        }
    }

    public void saveToMemento() {
        this.indexStack.push(new Memento(getIndex()));
    }

    public void getMemento() {
        setIndex(indexStack.pop().getIndex());
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
}
