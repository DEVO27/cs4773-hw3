package application.commands.interpreter;

import application.commands.*;
import application.model.CareTaker;
import application.shapes.Colors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class CmdLoader {
    private CreateRectangle createRectangle;
    private CreateCircle createCircle;
    private SelectShape selectShape;
    private ChangeColor changeColor;
    private Stack<String> invokerStack;
    private UndoCommand undoCommand;
    private Invoker invoker;
    private CareTaker careTaker;

    public void readFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String line;
            invokerStack = new Stack<>();
            selectShape = new SelectShape(0);
            careTaker = new CareTaker();
            while ((line = bufferedReader.readLine()) != null) {
                String[] parse = line.split(" ");
                for (ValidCommands commands : ValidCommands.values()) {
                    if (line.contains(commands.label)) {
                        if (line.contains(ValidCommands.DRAW_SCENE.label)) {
                            choice(ValidCommands.DRAW_SCENE.label, parse);
                            invokerStack.push(ValidCommands.DRAW_SCENE.label);
                            break;
                        } else {
                            choice(commands.label, parse);
                            invokerStack.push(commands.label);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void choice(String command, String[] parse) {
        switch (command) {
            case "CREATE RECTANGLE" -> loadRectangle(parse);
            case "CREATE CIRCLE" -> loadCircle(parse);
            case "SELECT" -> loadSelected(parse);
            case "MOVE" -> loadMove(parse);
            case "DRAW" -> loadDraw();
            case "DRAWSCENE" -> loadDrawScene();
            case "COLOR" -> loadColor(parse);
            case "UNDO" -> loadUndo();
        }
    }


    public void loadRectangle(String[] cmd) {
        //Created the command
        int x = Integer.parseInt(cmd[2]);
        int y = Integer.parseInt(cmd[3]);
        //Create Command
        CreateRectangle createRectangle = new CreateRectangle(x, y);
        //Execute Command
        invoker = new Invoker(createRectangle);
        //Save Object in array
        selectShape.getShapes().add(createRectangle.getShape());
        selectShape.setActive(Boolean.FALSE);
    }

    public void loadCircle(String[] cmd) {
        //Created the command
        int radius = Integer.parseInt(cmd[2]);
        createCircle = new CreateCircle(radius);
        //Executed the command
        invoker = new Invoker(createCircle);
        //Store Shape
        selectShape.getShapes().add(createCircle.getShape());
        selectShape.setActive(Boolean.FALSE);
    }

    public void loadSelected(String[] cmd) {
        selectShape.setActive(Boolean.TRUE);
        selectShape.setIndex(Integer.parseInt(cmd[1]));
        invoker = new Invoker(selectShape);
    }

    public void loadMove(String[] cmd) {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            int x = Integer.parseInt(cmd[1]);
            int y = Integer.parseInt(cmd[2]);
            invoker = new Invoker(new MoveShape(selectShape.getCurShape(), x, y));
            selectShape.getShapes().set(selectShape.getIndex(), selectShape.getCurShape());
        } else {
            System.out.println("no shape selected");
        }
    }

    public void loadDraw() {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            invoker = new Invoker(new DrawShape(selectShape.getCurShape()));
        } else {
            System.out.println("no shape selected");
        }
    }

    public void loadColor(String[] cmd) {
        if (Boolean.TRUE.equals(selectShape.getActive())) {
            changeColor = new ChangeColor(selectShape.getCurShape(), Colors.valueOf(cmd[1]));
            invoker = new Invoker(changeColor);
            invoker.changeColor();
        } else {
            invoker = new Invoker(new SelectShape(0));
        }
    }

    public void loadDrawScene() {
        invoker = new Invoker(new DrawSceneShape(selectShape.getShapes()));
    }

    public void loadUndo() {
        undoCommand = new UndoCommand(invokerStack.pop(), selectShape);
        invoker = new Invoker(undoCommand);
        selectShape = undoCommand.getSelectShape();
    }
}
