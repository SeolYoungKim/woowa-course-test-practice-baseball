package baseball.view;

import baseball.domain.ComparisonResult;

public class OutputView {

    private final OutputViewFormatter outputViewFormatter;

    public OutputView(OutputViewFormatter outputViewFormatter) {
        this.outputViewFormatter = outputViewFormatter;
    }

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResults(ComparisonResult comparisonResult) {
        System.out.println(outputViewFormatter.resultFormat(comparisonResult));
    }

    public void printCorrectAnswerMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printGameEndMessage() {
        System.out.println("게임이 종료되었습니다.");
    }
}
