package application.commands;

import application.commands.interpreter.InvokeCommands;
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
        int index = sceneShape.getSavedShapes().size() - 1;
        int curIndex = selectShape.getIndex();
        switch (command) {
            case "CREATE RECTANGLE", "CREATE CIRCLE" -> sceneShape.getSavedShapes().remove(index);
            case "MOVE" -> new InvokeCommands(new MoveShape(sceneShape.getShape(curIndex))).undoMove();
            case "SELECT" -> new InvokeCommands(new SelectShape(curIndex)).undoSelect();
            case "COLOR" -> new InvokeCommands(new ChangeColor(sceneShape.getShape(curIndex))).undoColor();
            case "DELETE" -> new InvokeCommands(new DeleteShape(curIndex, sceneShape)).undoDeleteShape();
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
