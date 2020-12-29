

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/**
 * головной класс запуска функционала игры
 * */
public class Menu {

    // список ссылок инициализируемых оъектами класссов реализующих интерфейс Command
    // т.е реализующих разное поведение метода .getCommand()
    // в зависимости от класса его реализующего
    private List<Command> command;

    public Menu() {
        command = new ArrayList<>();
        command.add(new StartCommand());
        command.add(new LoadCommand());
        command.add(new ExitCommand());
    }

    // запуск игры
    public void run() {
        this.showMenu();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            int menuNumber = Integer.parseInt(input.readLine());
            this.command.get(menuNumber - 1).execute();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void showMenu() {
        System.out.println("Выберете действие:");
        for (int i = 0; i < command.size(); i++) {
            System.out.println( i + 1 + ". " + command.get(i).getCommand() + ".");
        }
    }
}
