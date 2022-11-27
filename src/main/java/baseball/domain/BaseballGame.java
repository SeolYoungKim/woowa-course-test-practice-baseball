package baseball.domain;

public class BaseballGame {

    private static final int INIT_VALUE_OF_GAME_COMMAND = 0;

    private int gameCommand;

    public BaseballGame() {
        this.gameCommand = INIT_VALUE_OF_GAME_COMMAND;
    }

    public boolean isEnd() {
        return gameCommand == 2;
    }

    public boolean isRestart() {
        return gameCommand == 1;
    }

    public void setGameCommand(int command) {
        gameCommand = command;
    }

    public void restart() {
        resetGameCommand();
    }

    private void resetGameCommand() {
        gameCommand = 0;
    }
}
