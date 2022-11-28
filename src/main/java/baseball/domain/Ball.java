package baseball.domain;

public class Ball {

    public int findCountBall(int strike, int correct) {
        int ball = 0;

        ball = correct - strike;
        return ball;
    }
}
