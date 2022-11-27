package baseball.view;

import baseball.domain.ComparisonResult;

public class OutputView {

    private final OutputViewFormatter outputViewFormatter;

    public OutputView(OutputViewFormatter outputViewFormatter) {
        this.outputViewFormatter = outputViewFormatter;
    }

    // 게임 시작 문구를 출력한다.
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시한다.
    public void printResults(ComparisonResult comparisonResult) {
        // 결과를 받고, 결과를 포맷에 맞게 출력!
        System.out.println(outputViewFormatter.resultFormat(comparisonResult));
    }

    // 모두 맞췄을 경우 결과 출력
    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
