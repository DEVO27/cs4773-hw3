package application.commands;

import application.model.Scene;

public class DeleteShape implements ICommand {
    private Scene scene;
    private int index;

    public DeleteShape(int index, Scene scene) {
        this.index = index;
        this.scene = scene;
    }

    @Override
    public void execute() {
        scene.saveToMemento();
        scene.getSavedShapes().remove(index);
    }

    @Override
    public void unExecute() {
        scene.getMemento();
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
