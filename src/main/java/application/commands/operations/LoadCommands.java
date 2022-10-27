package application.commands.operations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class LoadCommands {
    /***
     * Cross-references input file as commands
     * against valid command enum
     * @param fileName
     */
    public void readFile(String fileName) {
        Stack<String> inputCmd = new Stack<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            ProcessCommands processCommands = new ProcessCommands();
            while ((line = bufferedReader.readLine()) != null) {
                String[] parse = line.split(" ");
                for (ValidCommands commands : ValidCommands.values()) {
                    if (line.contains(commands.label)) {
                        if (line.contains(ValidCommands.DRAW_SCENE.label)) {
                            processCommands.choice(ValidCommands.DRAW_SCENE.label, parse, inputCmd);
                            inputCmd.push(commands.label);
                        } else {
                            processCommands.choice(commands.label, parse, inputCmd);
                            inputCmd.push(commands.label);
                        }
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
