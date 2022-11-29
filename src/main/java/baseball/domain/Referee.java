package baseball.domain;

public class Referee {
    private final IdenticalNumberCount identicalNumberCount;
    private final Strike strike;
    private final Ball ball;

    private int correct = 0;
    private int countStrike = 0;
    private int countBall = 0;

    public Referee(IdenticalNumberCount identicalNumberCount, Strike strike, Ball ball) {
        this.identicalNumberCount = identicalNumberCount;
        this.strike = strike;
        this.ball = ball;
    }

    public int refereeStatus(Baseball baseball) {
        correct = identicalNumberCount.findPlayersAndComputer(baseball);
        countStrike = strike.findCountStrike(baseball);
        countBall = ball.findCountBall(countStrike, correct);
        return correct;
    }

    public String Judgment() {
        if (correct == 0) {
            return "낫싱";
        }

        if (countBall > 0 && countStrike > 0) {
            return countBall + "볼 " + countStrike + "스트라이크";
        }

        if (countStrike > 0 && countBall == 0) {
            return countStrike + "스트라이크";
        }
        return countBall + "볼";
    }
}