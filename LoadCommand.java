

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;


public class LoadCommand implements Command {

    private String commandName = "Load Game";

    @Override
    public String getCommand() {
        return commandName;
    }

    @Override
    public void execute() {
        System.out.println("Выберите файл для загрузки игры");
        File dir = new File(".");
        File[] files = dir.listFiles();
        System.out.println(Arrays.toString(files));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = input.readLine();
            try (FileInputStream fileInputStream = new FileInputStream(fileName);
                ObjectInputStream stream = new ObjectInputStream(fileInputStream)) {
                Game game = (Game) stream.readObject();
                game.start();
            }
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }
    }
}
