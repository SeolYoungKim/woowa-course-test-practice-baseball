package baseball.domain;

public class ComparisonResult {

    private final int strikeCount;
    private final int ballCount;

    public ComparisonResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public int strikeCount() {
        return strikeCount;
    }

    public int ballCount() {
        return ballCount;
    }
}
