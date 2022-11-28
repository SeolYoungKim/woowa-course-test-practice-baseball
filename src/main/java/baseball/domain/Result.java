package baseball.domain;

public class Result {

    private final int ball;
    private final int strike;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int ball() {
        return ball;
    }

    public int strike() {
        return strike;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean isSuccess() {
        return strike == Numbers.NUMBERS_SIZE;
    }
}
