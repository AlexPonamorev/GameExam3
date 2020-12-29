

public class ExitCommand implements Command{

    private String commandName = "Exit";

    @Override
    public String getCommand() {
        return commandName;
    }

    @Override
    public void execute() {
        System.out.println(" Выход из игры ");
    }
}
