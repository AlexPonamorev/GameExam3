

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game implements Serializable {

    private List<NodeFunctionalOfGame> nodeFunctionalList = new ArrayList<>();
    private NodeFunctionalOfGame nodeFuncGameHere = null;
    private transient final int COUNT = 13;
    private final static long serialVersionUID = 1L;
    //private GameNode node;

    public Game() {
        // инициализация шагов в игре
        // id при инициализации - 0
        for (int i = 0; i < COUNT; i++) {
            nodeFunctionalList.add(new NodeFunctionalOfGame(i));
        }
        // граф зависимостей
        // устанавливается следующие варианты  перехода между узлами
        // т.е ссылки на узлы перехода
        nodeFunctionalList.get(0).setNextSolutionOne(nodeFunctionalList.get(5)); // инициализация ссылки с 0 -> на 5 узел  -> правильный ход
        nodeFunctionalList.get(0).setNextSolutionTwo(nodeFunctionalList.get(1));
        nodeFunctionalList.get(1).setNextSolutionOne(nodeFunctionalList.get(3));
        nodeFunctionalList.get(1).setNextSolutionTwo(nodeFunctionalList.get(2));
        nodeFunctionalList.get(2).setNextSolutionOne(null);  // решение не правильное
        nodeFunctionalList.get(2).setNextSolutionTwo(null);
        nodeFunctionalList.get(3).setNextSolutionOne(nodeFunctionalList.get(4));
        nodeFunctionalList.get(3).setNextSolutionTwo(nodeFunctionalList.get(7));
        nodeFunctionalList.get(4).setNextSolutionOne(nodeFunctionalList.get(5));
        nodeFunctionalList.get(4).setNextSolutionTwo(nodeFunctionalList.get(2));
        nodeFunctionalList.get(5).setNextSolutionOne(null);
        nodeFunctionalList.get(5).setNextSolutionTwo(null);
        nodeFunctionalList.get(6).setNextSolutionOne(nodeFunctionalList.get(8));
        nodeFunctionalList.get(6).setNextSolutionTwo(nodeFunctionalList.get(2));
        nodeFunctionalList.get(7).setNextSolutionOne(nodeFunctionalList.get(6));
        nodeFunctionalList.get(7).setNextSolutionTwo(nodeFunctionalList.get(2));
        nodeFunctionalList.get(8).setNextSolutionOne(nodeFunctionalList.get(11));
        nodeFunctionalList.get(8).setNextSolutionTwo(nodeFunctionalList.get(9));
        nodeFunctionalList.get(9).setNextSolutionOne(null);
        nodeFunctionalList.get(9).setNextSolutionTwo(null);
        nodeFunctionalList.get(10).setNextSolutionOne(nodeFunctionalList.get(5));
        nodeFunctionalList.get(10).setNextSolutionTwo(nodeFunctionalList.get(2));
        nodeFunctionalList.get(11).setNextSolutionOne(nodeFunctionalList.get(10));
        nodeFunctionalList.get(11).setNextSolutionTwo(nodeFunctionalList.get(12));
        nodeFunctionalList.get(12).setNextSolutionOne(null);
        nodeFunctionalList.get(12).setNextSolutionTwo(null);
    }

    public void start() throws IOException {
        NodeFunctionalOfGame nodeFunctionalOfGame;

        if (Objects.isNull(this.nodeFuncGameHere)) {
            nodeFunctionalOfGame = nodeFunctionalList.get(0);
        } else nodeFunctionalOfGame = this.nodeFuncGameHere;
        String usersChoice = "";

        // пока решения правильные
        while (Objects.nonNull(nodeFunctionalOfGame.getLinkNextSolutionOne())) {
            System.out.println(Objects.nonNull(nodeFunctionalOfGame.getLinkNextSolutionOne()));
            // считать пользовательский ввод
            usersChoice = inputProcessing(nodeFunctionalOfGame);
            if (usersChoice.startsWith("1") || usersChoice.startsWith("2")) {
                nodeFunctionalOfGame = makeChoice(usersChoice, nodeFunctionalOfGame);
            } else if (usersChoice.contains("сохранить")) {
                //
                this.nodeFuncGameHere = nodeFunctionalOfGame;
                saveGame();
                System.out.println("Игра сохранена");
                break;
            } else {
                System.out.println("Enter 1 or 2 or save!");
                continue;
            }
        }
        if (!usersChoice.equalsIgnoreCase("сохранить"))
            System.out.println(nodeFunctionalOfGame.getNode().getNodeDescription());
    }

    private void saveGame() throws IOException {
        System.out.println("Enter name of file");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        File fileName = new File(input.readLine());
        try (FileOutputStream stream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream)) {
            objectOutputStream.writeObject(this);  // Ключевое слово this всегда является ссылкой на экземпляр класса в котором оно используется
        }
    }

    private String inputProcessing(NodeFunctionalOfGame nodeFunctionalOfGame) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        // вывод содержания стартового узла
        System.out.println(nodeFunctionalOfGame.getNode().getNodeDescription());
        System.out.println("Выберете действие:");
        {
            System.out.println("1. " + nodeFunctionalOfGame.getNode().getTextRightSolution());
            System.out.println("2. " + nodeFunctionalOfGame.getNode().getTextWrongSolution());
        }
        System.out.println(" Введите 1 или 2 для выбора решения или \"сохранить\"  чтобы сохранить эту игру ");
        return input.readLine(); // считать ввод с клавиатуры
    }

    private NodeFunctionalOfGame makeChoice(String userChoice, NodeFunctionalOfGame nodeFunctionalOfGame) {
       NodeFunctionalOfGame linkToNextNode = null;

            if (userChoice.startsWith("1"))
            linkToNextNode =   nodeFunctionalOfGame.getLinkNextSolutionOne();

            if (userChoice.startsWith("2"))
                linkToNextNode =  nodeFunctionalOfGame.getLinkNextSolutionTwo();
            return linkToNextNode;
    }

}
