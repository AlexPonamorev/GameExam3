

import java.io.IOException;

public class StartCommand implements Command{

    private String commandName = "Start";

    @Override
    public String getCommand() {
        return commandName;
    }

    @Override
    public void execute() {
        Game game = new Game();
        try {
            game.start();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
