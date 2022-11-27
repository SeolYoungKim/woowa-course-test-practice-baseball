package baseball.view;

import java.util.StringJoiner;

public class OutputView {

    private final OutputFormatter outputFormatter;

    public OutputView(OutputFormatter outputFormatter) {
        this.outputFormatter = outputFormatter;
    }

    public void printGameStart() {
        printLine("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(int ball, int strike) {
        String result = outputFormatter.formatResult(ball, strike);
        printLine(result);
    }

    public void printSuccess() {
        printLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void print(String s, Object... args) {
        System.out.printf(s, args);
    }

    private void printLine(String s, Object... args) {
        print(s + "\n", args);
    }
}
