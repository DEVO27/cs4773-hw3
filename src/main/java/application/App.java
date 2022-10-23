package application;

import application.commands.loader.CmdLoader;

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
    }
}
