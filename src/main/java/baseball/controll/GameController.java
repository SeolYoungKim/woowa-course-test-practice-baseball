package baseball.controll;

import baseball.domain.Duplicate;
import baseball.domain.Judgement;
import baseball.domain.RandomNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.Objects;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumber randomNumber = new RandomNumber();
    private final Judgement judgement = new Judgement(new Duplicate());

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.startGame();
        startBaseball();
    }

    private void startBaseball() {
        makeAnswerNumber();
        retryOrFinish();
    }

    private void makeAnswerNumber() {
        List<Integer> answerNumber = randomNumber.makeAnswer();
        baseball(answerNumber);
    }

    private void baseball(List<Integer> answerNumber) {
        List<Integer> player = getNumber();
        judgementBallOrStrike(answerNumber, player);
    }

    private List<Integer> getNumber() {
        outputView.askNumber();
        return inputView.readPlayerNumber();
    }

    private void judgementBallOrStrike(List<Integer> answerNumber, List<Integer> player) {
        int strike = judgement.strike(answerNumber, player);
        int ball = judgement.ball(answerNumber, player);
        outputView.informResult(ball, strike);
        checkStrike(strike, answerNumber);
    }

    private void checkStrike(int strike, List<Integer> answerNumber) {
        if (strike != 3) {
            baseball(answerNumber);
        }
    }

    private void retryOrFinish() {
        String retry = getRetryNumber();
        if (checkRetry(retry)) {
            startBaseball();
        }
    }

    private String getRetryNumber() {
        outputView.correctAnswer();
        outputView.askRetry();
        return inputView.readRetry();
    }

    private boolean checkRetry(String d) {
        return Objects.equals(d, "1");
    }
}
