package application.commands;

import application.commands.operations.InvokeCommands;
import application.model.Scene;

public class UndoCommand implements ICommand {
    private final Scene sceneShape;
    private final String command;
    private final SelectShape selectShape;

    public UndoCommand(String command, Scene sceneShape, SelectShape selectShape) {
        this.sceneShape = sceneShape;
        this.command = command;
        this.selectShape = selectShape;
    }

    private void choice() {
        int curIndex = selectShape.getIndex();
        int index = sceneShape.getSavedShapes().size() - 1;
        switch (command) {
            case "CREATE RECTANGLE", "CREATE CIRCLE" -> sceneShape.getSavedShapes().remove(index);
            case "MOVE" -> new InvokeCommands(new MoveShape(sceneShape.getShape(curIndex))).unExecuteMove();
            case "SELECT" -> new InvokeCommands(this.selectShape).unExecuteSelect();
            case "COLOR" -> new InvokeCommands(new ChangeColor(sceneShape.getShape(curIndex))).unExecuteColor();
            case "DELETE" -> new InvokeCommands(new DeleteShape(selectShape, sceneShape)).unExecuteDelete();
        }
    }

    @Override
    public void execute() {
        choice();
    }

    @Override
    public void unExecute() {
    }

    public Scene getSceneShape() {
        return sceneShape;
    }

    public String getCommand() {
        return command;
    }

    public SelectShape getSelectShape() {
        return selectShape;
    }
}
