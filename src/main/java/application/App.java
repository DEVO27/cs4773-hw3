package application;

import application.commands.operations.LoadCommands;

/**
 * Beginning of the application
 */
public class App {
    public static void main(String[] args) {
        new LoadCommands().readFile(args[0]);
    }
}
