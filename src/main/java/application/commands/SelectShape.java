package application.commands;

import java.util.Stack;

public class Scene implements ICommand {
    private Stack<Memento> indexStack = new Stack<>();
    private Boolean active;
    /*private List<Shape> shapes;
    private Stack previousIndex;
    private Shape curShape; */
    private int index;

    public Scene(int index) {
        this.index = index - 1;
        /*this.previousIndex = new Stack<>();
        this.shapes = new ArrayList<>(); */
    }

    @Override
    public void execute() throws IndexOutOfBoundsException {
        saveToMemento();
        setIndex(index);
        /**previousIndex.push(index);
        setCurShape(shapes.get(index)); ***/
    }

    @Override
    public void unExecute() {
        getMemento();
        /*if (!getPreviousIndex().isEmpty()) {
            setCurShape(shapes.get((int) getPreviousIndex().pop()));
        } else {
            System.out.println("No Shape");
        } */
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

    /**public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public Shape getCurShape() {
        return curShape;
    }

    public void setCurShape(Shape curShape) {
        this.curShape = curShape;
    } **/

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /***public Stack getPreviousIndex() {
        return previousIndex;
    }

    public void setPreviousIndex(Stack previousIndex) {
        this.previousIndex = previousIndex;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    } **/

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
