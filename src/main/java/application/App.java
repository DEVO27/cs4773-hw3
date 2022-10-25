package application;

import application.commands.operations.LoadCommands;
public class App {
    public static void main(String[] args) {
        LoadCommands loadCommands = new LoadCommands();
        loadCommands.readFile("InputSet1.txt");
    }
}
