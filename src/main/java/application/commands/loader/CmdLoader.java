package application.commands.loader;

import application.commands.CreateCircle;
import application.commands.CreateRectangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommandLoader {
    private CreateRectangle createRectangle;
    private CreateCircle createCircle;
    public void readFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("CREATE RECTANGLE")) {
                    String[] command = line.split(" ");
                    int x = Integer.parseInt(command[2]);
                    int y = Integer.parseInt(command[3]);
                    this.createRectangle = new CreateRectangle(x, y);
                } else if (line.contains("CREATE CIRCLE")) {
                    String[] command = line.split(" ");
                    int radius = Integer.parseInt(command[2]);
                    this.createCircle = new CreateCircle(radius);
                } else if (line.contains("SELECT")) {

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
