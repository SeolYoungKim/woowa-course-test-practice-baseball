package baseball.view;

import baseball.domain.ComparisonResult;
import java.util.StringJoiner;

public class OutputViewFormatter {

    String resultFormat(ComparisonResult comparisonResult) {
        if (comparisonResult.isNothing()) {
            return "낫싱";
        }

        return ballAndStrikeFormat(comparisonResult);
    }

    private String ballAndStrikeFormat(ComparisonResult comparisonResult) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        if (comparisonResult.hasMoreThanOneBall()) {
            stringJoiner.add(comparisonResult.ballCount() + "볼");
        }

        if (comparisonResult.hasMoreThanOneStrike()) {
            stringJoiner.add(comparisonResult.strikeCount() + "스트라이크");
        }
        return stringJoiner.toString();
    }
}
