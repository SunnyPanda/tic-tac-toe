package tictactoe;

public enum GameState {
    X_WINS("X wins"),
    O_WINS("O wins"),
    DRAW("Draw"),
    NOT_FINISHED("Game not finished");

    String message;

    GameState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
