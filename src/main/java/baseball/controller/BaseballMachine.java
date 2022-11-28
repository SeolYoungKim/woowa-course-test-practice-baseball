package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.Baseball;
import baseball.domain.IdenticalNumberCount;
import baseball.domain.RandomGenerator;
import baseball.domain.Referee;
import baseball.domain.Strike;
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
        int restart = 1;
        while (restart == 1) {

            RandomGenerator randomGenerator = new RandomGenerator();
            List<Integer> computer = randomGenerator.computerNumber();

            IdenticalNumberCount identicalNumberCount = new IdenticalNumberCount();

            Strike strike = new Strike();
            Ball ball = new Ball();
            Referee referee = new Referee();

            String judgment = "";

            while (!(judgment.equals("3스트라이크"))) {
                playerOutput.printNumberInput();
                List<Integer> player = playerInput.startGameInput();

                Baseball baseball = new Baseball(player, computer);

                int correct = identicalNumberCount.findPlayersAndComputer(baseball);
                int countStrike = strike.findCountStrike(baseball);
                int countball = ball.findCountBall(countStrike, correct);

                judgment = referee.Judgment(countball, countStrike, correct);

                if (correct == 0) {
                    playerOutput.printNotSing(judgment);
                }

                if (correct >= 1) {
                    playerOutput.printResult(judgment);
                }
            }
            playerOutput.printAnswer();
            playerOutput.printRestartGame();
            restart = playerInput.restartGameInput();
        }
    }
}
