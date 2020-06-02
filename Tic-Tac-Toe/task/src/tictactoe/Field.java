package tictactoe;

public class Field {
    private char[][] cells;
    private final int size;
    private boolean isFirstPlayer;

    public Field(int size) {
        cells = new char[size][size];
        this.size = size;
        isFirstPlayer = true;
    }

    public void setField() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public void setMove(int row, int col) {
        cells[row][col] = isFirstPlayer ? 'X' : 'O';
        isFirstPlayer = !isFirstPlayer;
    }

    boolean hasThreeInARow(char symbol) {
        return checkRows(symbol) || checkColumns(symbol) ||checkLeftDiagonal(symbol) || checkRightDiagonal(symbol);
    }

    private boolean checkRows(char symbol) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] == symbol) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkColumns(char symbol) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[j][i] == symbol) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkLeftDiagonal(char symbol) {
        return cells[0][0] == symbol && cells[1][1] == symbol && cells[2][2] == symbol;
    }

    private boolean checkRightDiagonal(char symbol) {
        return cells[0][2] == symbol && cells[1][1] == symbol && cells[2][0] == symbol;
    }

    boolean hasEmptyCells() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }

   public char[][] getCells() {
        return cells;
   }

   public int getSize() {
        return size;
   }
}
