package baseball.view;

import baseball.domain.ComparisonResult;
import java.util.StringJoiner;

public class OutputViewFormatter {

    private static final String NEITHER_STRIKE_NOR_BALL = "낫싱";
    private static final String BLANK = " ";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    String resultFormat(ComparisonResult comparisonResult) {
        if (comparisonResult.isNothing()) {
            return NEITHER_STRIKE_NOR_BALL;
        }

        return ballAndStrikeFormat(comparisonResult);
    }

    private String ballAndStrikeFormat(ComparisonResult comparisonResult) {
        StringJoiner stringJoiner = new StringJoiner(BLANK);
        if (comparisonResult.hasMoreThanOneBall()) {
            stringJoiner.add(comparisonResult.ballCount() + BALL);
        }

        if (comparisonResult.hasMoreThanOneStrike()) {
            stringJoiner.add(comparisonResult.strikeCount() + STRIKE);
        }
        return stringJoiner.toString();
    }
}
