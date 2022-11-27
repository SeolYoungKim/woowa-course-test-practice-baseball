package baseball;

import baseball.domain.Duplicate;
import baseball.domain.Judgement;
import baseball.domain.RandomNumber;

import java.util.List;
import java.util.Objects;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumber randomNumber = new RandomNumber();
    private final Judgement judgement = new Judgement(new Duplicate());

    GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.startGame();
        startBaseball();
    }

    public void startBaseball() {
        makeAnswerNumber();
        retryOrFinish();
    }

    public void makeAnswerNumber() {
        List<Integer> answerNumber = randomNumber.makeAnswer();
        baseball(answerNumber);
    }

    public void baseball(List<Integer> answerNumber) {
        List<Integer> player = getNumber();
        h(answerNumber, player);
    }

    public List<Integer> getNumber() {
        outputView.askNumber();
        return inputView.readPlayerNumber();
    }

    public void h(List<Integer> answerNumber, List<Integer> player) {
        int strike = judgement.strike(answerNumber, player);
        int ball = judgement.ball(answerNumber, player);
        outputView.informResult(ball, strike);
        checkStrike(strike, answerNumber);
    }

    public void checkStrike(int strike, List<Integer> answerNumber) {
        if (strike != 3) {
            baseball(answerNumber);
        }
    }

    public void retryOrFinish() {
        String retry = getRetryNumber();
        if (checkRetry(retry)) {
            startBaseball();
        }
    }

    public String getRetryNumber() {
        outputView.correctAnswer();
        outputView.askRetry();
        return inputView.readRetry();
    }

    public boolean checkRetry(String d) {
        return Objects.equals(d, "1");
    }
}
