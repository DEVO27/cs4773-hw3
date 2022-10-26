package application.commands;

import application.model.Scene;

public class DrawShape implements ICommand {
    private Scene scene;
    private SelectShape selectShape;

    public DrawShape(Scene scene, SelectShape selectShape) {
        this.scene = scene;
        this.selectShape = selectShape;
    }

    @Override
    public void execute() {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            System.out.println(scene.getShape(selectShape.getIndex()));
        } else {
            System.out.println("no shape selected");
        }
    }

    @Override
    public void unExecute() {

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
