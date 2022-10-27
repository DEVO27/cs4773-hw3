package application.commands;

import application.model.Scene;

public class DeleteShape implements ICommand {
    private Scene scene;
    private SelectShape selectShape;

    public DeleteShape(SelectShape selected, Scene scene) {
        this.selectShape = selected;
        this.scene = scene;
    }

    /***
     * Deletes shape from list IFF select was a previous command
     */
    @Override
    public void execute() {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            int index = selectShape.getIndex();
            scene.saveToMemento();
            scene.getSavedShapes().remove(index);
        } else {
            System.out.println("No shape selected");
        }
        selectShape.setActive(Boolean.FALSE);
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

    public SelectShape getSelectShape() {
        return selectShape;
    }

    public void setSelectShape(SelectShape selectShape) {
        this.selectShape = selectShape;
    }
}
