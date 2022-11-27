package baseball.view;

import baseball.domain.Result;
import java.util.StringJoiner;

public class OutputFormatter {

    String formatResult(Result result) {
        if (result.isNothing()) {
            return "낫싱";
        }

        StringJoiner joiner = new StringJoiner(" ");
        if (result.ball() > 0) {
            joiner.add(result.ball() + "볼");
        }
        if (result.strike() > 0) {
            joiner.add(result.strike() + "스트라이크");
        }

        return joiner.toString();
    }
}
