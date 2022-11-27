package baseball.domain;

public class ComparisonResult {

    private final Counts strikeCount;
    private final Counts ballCount;

    public ComparisonResult(Counts strikeCount, Counts ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isNothing() {
        return strikeCount.isZero() && ballCount.isZero();
    }

    public boolean hasMoreThanOneStrike() {
        return strikeCount.isMoreThanOne();
    }

    public boolean hasMoreThanOneBall() {
        return ballCount.isMoreThanOne();
    }

    public boolean isThreeStrike() {
        return strikeCount.isThree();
    }

    public int strikeCount() {
        return strikeCount.value();
    }

    public int ballCount() {
        return ballCount.value();
    }
}
