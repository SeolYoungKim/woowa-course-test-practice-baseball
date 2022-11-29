package baseball.controller;

import baseball.domain.*;
import baseball.view.PlayerInput;
import baseball.view.PlayerOutput;

import java.util.List;

public class BaseballMachine {
    private final PlayerInput playerInput;
    private final PlayerOutput playerOutput;

    public BaseballMachine(PlayerInput playerInput, PlayerOutput playerOutput) {
        this.playerInput = playerInput;
        this.playerOutput = playerOutput;
    }

    public void run() {
        playerOutput.printStartGame();
        gameRestartJudgment();
    }

    private void gameRestartJudgment() {
        int restart = 1;
        while (restart == 1) {
            List<Integer> computer = RandomNumber();
            Referee referee = new Referee(new IdenticalNumberCount(), new Strike(), new Ball());

            gameJudgment(computer, referee);
            restart = gameRestart();
        }
    }

    private void gameJudgment(List<Integer> computer, Referee referee) {
        String judgment = "";
        while (!(judgment.equals("3스트라이크"))) {
            Baseball baseball = playerInput(computer);
            int correct = referee.refereeStatus(baseball);

            judgment = referee.Judgment();
            resultOutput(judgment, correct);
        }
    }

    private void resultOutput(String judgment, int correct) {
        if (correct == 0) {
            playerOutput.printNotSing(judgment);
        }

        if (correct >= 1) {
            playerOutput.printResult(judgment);
        }
    }

    private List<Integer> RandomNumber() {
        RandomGenerator randomGenerator = new RandomGenerator();
        return randomGenerator.computerNumber();
    }

    private int gameRestart() {
        int restart;
        playerOutput.printAnswer();
        playerOutput.printRestartGame();

        restart = playerInput.restartGameInput();
        return restart;
    }

    private Baseball playerInput(List<Integer> computer) {
        playerOutput.printNumberInput();
        List<Integer> player = playerInput.startGameInput();
        return new Baseball(player, computer);
    }
}