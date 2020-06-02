package tictactoe;

public class InputValidation {
    private static final String CELL_OCCUPIED = "This cell is occupied! Choose another one!";
    private static final String NOT_NUMBER = "You should enter numbers!";
    private static final String WRONG_RANGE = "Coordinates should be from 1 to 3!";

    private final Field field;
    private String message;
    private int x;
    private int y;

    public InputValidation(Field field) {
        this.field = field;
    }

    public boolean isValid(String input) {
        String[] coordinates = input.split("\\s+");
        for (String coordinate : coordinates) {
            if (!isNumeric(coordinate)) {
                return false;
            }
        }
        if (coordinates.length == 2) {
            x = Integer.parseInt(coordinates[0]);
            y = Integer.parseInt(coordinates[1]);
        }
        return isInRange() && isNotOccupied();
    }

    private boolean isNumeric(String strNum) {
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            message = NOT_NUMBER;
            return false;
        }
        return true;
    }

    private boolean isInRange() {
        if (x < 1 || x > 3 || y < 1 || y > 3) {
            message = WRONG_RANGE;
            return false;
        }
        return true;
    }

    private boolean isNotOccupied() {
        int column = x - 1;
        int row = 0;
        switch (y) {
            case 1: row = 2;
                break;
            case 2: row = 1;
        }
        if (field.getCells()[row][column] == 'X' || field.getCells()[row][column] == 'O') {
            message = CELL_OCCUPIED;
            return false;
        }
        return true;
    }

    public String getMessage() {
        return message;
    }

}
