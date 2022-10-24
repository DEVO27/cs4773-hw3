package application;

import application.commands.loader.CmdLoader;
import application.shapes.Colors;
import application.shapes.Rectangle;
import application.shapes.Shape;

import java.util.ArrayList;

/**
 * Hello world!
 * @author Austen Green
 * @author ker TODO <-- Need yah name bro
 * abc123: yni845
 * abc123: TODO <-- place abc123
 */
public class App {
    public static void main(String[] args) {
        CmdLoader loader = new CmdLoader();
        loader.readFile("InputSet1.txt");
        /*ArrayList<Shape.Memento> shapes = new ArrayList<>();
        Shape rectangle = new Rectangle(0, 1);
        rectangle.setColor(Colors.Red);
        rectangle.saveToMemento();
        System.out.println("Original " + rectangle);
        rectangle.setYCoordinate(1000);
        rectangle.setXCoordinate(50);
        rectangle.setColor(Colors.Blue);
        System.out.println("Updated " + rectangle);
        rectangle.getMemento();
        System.out.println("Back to Original " + rectangle); */
    }
}
