package application;

import application.commands.interpreter.LoadCommands;

/**
 * @author Austen Green
 * @author ker TODO <-- Need yah name bro
 * abc123: yni845
 * abc123: TODO <-- place abc123
 */
public class App {
    public static void main(String[] args) {
        LoadCommands loadCommands = new LoadCommands();
        loadCommands.readFile("InputSet1.txt");
    }
}
