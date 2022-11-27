package baseball.view;

import java.util.StringJoiner;

public class OutputFormatter {

    String formatResult(int ball, int strike) {
        if (isResultNothing(ball, strike)) {
            return "낫싱";
        }

        StringJoiner joiner = new StringJoiner(" ");
        if (ball > 0) {
            joiner.add(ball + "볼");
        }
        if (strike > 0) {
            joiner.add(ball + "스트라이크");
        }

        return joiner.toString();
    }

    private boolean isResultNothing(int ball, int strike) {
        return ball == 0 && strike == 0;
    }
}
