package application;

import application.commands.operations.LoadCommands;

public class App {
    public static void main(String[] args) {
        new LoadCommands().readFile(args[1]);
    }
}
