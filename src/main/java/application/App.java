package application;

import application.commands.loader.CmdLoader;

/**
 * Hello world!
 * @author Austen Green
 * abc123: yni845
 */
public class App {
    public static void main(String[] args) {
        CmdLoader loader = new CmdLoader();
        loader.readFile("InputSet1.txt");
    }
}
