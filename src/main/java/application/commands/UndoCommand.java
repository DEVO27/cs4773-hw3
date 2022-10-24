package application.commands;

import application.commands.loader.Invoker;

public class UndoCommand implements ICommand {
    private final SelectShape selectShape;
    private final String command;

    public UndoCommand(String command, SelectShape selectShape) {
        this.selectShape = selectShape;
        this.command = command;
    }

    private void select() {
        int index = selectShape.getShapes().size() - 1;
        switch (command) {
            case "CREATE RECTANGLE", "CREATE CIRCLE" -> selectShape.getShapes().remove(index);
            case "MOVE" -> new Invoker(new MoveShape(selectShape.getCurShape())).undoMove();
            case "SELECT" -> new Invoker(new SelectShape(selectShape.getIndex())).undoSelect();
            case "COLOR" -> new Invoker(new ChangeColor(selectShape.getCurShape())).undoColor();
        }
    }


    @Override
    public void execute() {
        select();
    }

    @Override
    public void unExecute() {
    }

    public SelectShape getSelectShape() {
        return selectShape;
    }

    public String getCommand() {
        return command;
    }
}
