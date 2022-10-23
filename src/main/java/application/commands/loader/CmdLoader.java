package application.commands.loader;

import application.commands.*;
import application.shapes.Colors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CmdLoader {
    private CreateRectangle createRectangle;
    private CreateCircle createCircle;
    private SelectShape selectShape;
    private DrawShape drawShape;
    private MoveShape moveShape;
    private ChangeColor changeColor;
    private ArrayList<Invoker> invokers;
    private Invoker invoker;

    public void readFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String line;
            selectShape = new SelectShape(0);
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println("Command used " + line);
                String[] cmd = line.split(" ");
                if (line.contains("CREATE RECTANGLE")) {
                    loadRectangle(cmd);
                } else if (line.contains("CREATE CIRCLE")) {
                    loadCircle(cmd);
                } else if (line.contains("SELECT")) {
                    loadSelected(cmd);
                } else if (line.contains("MOVE")) {
                    loadMove(cmd);
                } else if (line.contains("DRAW")) {
                    if (line.contains("DRAWSCENE")){
                        loadDrawScene();
                    } else {
                        loadDraw(cmd);
                    }
                } else if (line.contains("COLOR")) {
                    loadColor(cmd);
                } else if (line.contains("DELETE")) {
                    System.out.println("Working on it");
                } else if (line.contains("UNDO")) {
                    System.out.println("Working On it");
                } else {
                    System.out.println("Working On it");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadRectangle(String[] cmd) {
        //Created the command
        int x = Integer.parseInt(cmd[2]);
        int y = Integer.parseInt(cmd[3]);
        createRectangle = new CreateRectangle(x, y);
        //Executed the command
        invoker = new Invoker(createRectangle);
        //Store Shape
        selectShape.getShapes().add(createRectangle.getShape());
    }

    public void loadCircle(String[] cmd) {
        //Created the command
        int radius = Integer.parseInt(cmd[2]);
        createCircle = new CreateCircle(radius);
        //Executed the command
        invoker = new Invoker(createCircle);
        //Store Shape
        selectShape.getShapes().add(createCircle.getShape());
    }

    public void loadSelected(String[] cmd) {
        selectShape.setIndex(Integer.parseInt(cmd[1]));
        invoker = new Invoker(selectShape);
    }

    public void loadMove(String[] cmd) {
        int x = Integer.parseInt(cmd[1]);
        int y = Integer.parseInt(cmd[2]);
        invoker = new Invoker(new MoveShape(selectShape.getCurShape(), x, y));
        selectShape.getShapes().set(selectShape.getIndex(), selectShape.getCurShape());
    }

    public void loadDraw(String[] cmd) {
        invoker = new Invoker(new DrawShape(selectShape.getCurShape()));
    }

    public void loadColor(String[] cmd) {
        changeColor = new ChangeColor(selectShape.getCurShape(), Colors.valueOf(cmd[1]));
        invoker = new Invoker(changeColor);
    }

    public void loadDrawScene() {
        invoker = new Invoker(new DrawSceneShape(selectShape.getShapes()));
    }
}
