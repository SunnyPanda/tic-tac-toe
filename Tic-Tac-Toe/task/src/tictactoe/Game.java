package tictactoe;

import java.util.Scanner;

public class Game {
    private int row;
    private int column;

    private final Scanner scanner;

    private final Field field;
    private final InputValidation inputValidation;
    private GameState gameState;

    public Game() {
        field = new Field(3);
        inputValidation = new InputValidation(field);
        scanner = new Scanner(System.in);
        gameState = GameState.NOT_FINISHED;
    }
    public void process() {
        initialState();
        while (gameState == GameState.NOT_FINISHED) {
            askForMove();
            processInput();
            setNewMove();
            printField();
            checkState();
        }
        printResult();
    }

    public void initialState() {
        field.setField();
        printField();
    }

    private void printField() {
        System.out.println("---------");
        for (char[] cells : field.getCells()) {
            System.out.print("| ");
            for (int j = 0; j < field.getSize(); j++) {
                System.out.print(cells[j] + (j < field.getSize() - 1 ? " " : " | \n"));
            }
        }
        System.out.println("---------");
    }

    private void askForMove() {
        System.out.print("Enter the coordinates: ");
    }

    private void processInput() {
        String coordinates = scanner.nextLine();
        while (!inputValidation.isValid(coordinates)) {
            System.out.println(inputValidation.getMessage());
            askForMove();
            coordinates = scanner.nextLine();
        }
        convertInput(coordinates);
    }

    public void convertInput(String input) {
        String[] coordinates = input.split("\\s+");
        column = Integer.parseInt(coordinates[0]) - 1;
        switch (Integer.parseInt(coordinates[1])) {
            case 1: row = 2;
                break;
            case 2: row = 1;
                break;
            case 3: row = 0;
        }
    }

    private void setNewMove() {
        field.setMove(row, column);
    }

    private void checkState() {
        boolean hasThreeInARowX = field.hasThreeInARow('X');
        boolean hasThreeInARowO = field.hasThreeInARow('O');
        boolean hasEmptyCells = field.hasEmptyCells();
        if (hasThreeInARowX) {
            gameState = GameState.X_WINS;
        } else if (hasThreeInARowO) {
            gameState = GameState.O_WINS;
        } else if (!hasEmptyCells) {
            gameState = GameState.DRAW;
        } else {
            gameState = GameState.NOT_FINISHED;
        }
    }

    private void printResult() {
        System.out.println(gameState.getMessage());
    }
}
