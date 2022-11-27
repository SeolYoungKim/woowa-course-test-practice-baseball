package baseball.domain;

public class BaseballGame {

    private GameCommand gameCommand;

    public BaseballGame() {
        this.gameCommand = GameCommand.INIT;
    }

    public boolean isEnd() {
        return gameCommand.is(GameCommand.QUIT);
    }

    public boolean isRestart() {
        return gameCommand.is(GameCommand.RESTART);
    }

    public void setGameCommand(GameCommand command) {
        gameCommand = command;
    }

    public void restart() {
        resetGameCommand();
    }

    private void resetGameCommand() {
        gameCommand = GameCommand.INIT;
    }
}
