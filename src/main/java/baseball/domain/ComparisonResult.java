package baseball.domain;

public class ComparisonResult {

    private final int strikeCount;
    private final int ballCount;

    public ComparisonResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public boolean hasMoreThanOneStrike() {
        return 1 <= strikeCount;
    }

    public boolean hasMoreThanOneBall() {
        return 1 <= ballCount;
    }

    public boolean isThreeStrike() {
        return strikeCount == 3;
    }

    public int strikeCount() {
        return strikeCount;
    }

    public int ballCount() {
        return ballCount;
    }
}
