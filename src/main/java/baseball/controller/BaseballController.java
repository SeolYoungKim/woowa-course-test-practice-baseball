package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballNumbersGenerator;
import baseball.domain.ComparisonResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballNumbersGenerator baseballNumbersGenerator;

    public BaseballController(InputView inputView, OutputView outputView,
            BaseballNumbersGenerator baseballNumbersGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballNumbersGenerator = baseballNumbersGenerator;
    }

    public void run() {
        outputView.printStartMessage();
        gameStart();

        System.out.println("게임이 종료되었습니다.");
    }

    private void gameStart() {
        BaseballNumbers computerNumbers = baseballNumbersGenerator.randomNumbersForComputer();
        int gameCommand = 0;

        while (gameCommand != 2) {
            ComparisonResult comparisonResult = inputAndComparison(computerNumbers);

            if (comparisonResult.isThreeStrike()) {
                outputView.printEndMessage();
                gameCommand = inputView.restartOrQuit();
            }

            if (gameCommand == 1) {
                computerNumbers = baseballNumbersGenerator.randomNumbersForComputer();
                gameCommand = 0;
            }
        }
    }

    private ComparisonResult inputAndComparison(BaseballNumbers computerNumbers) {
        String numbers = inputView.numbers();
        BaseballNumbers inputNumbers = baseballNumbersGenerator.baseballNumbers(numbers);

        ComparisonResult comparisonResult = inputNumbers.comparisonResult(computerNumbers);
        outputView.printResults(comparisonResult);

        return comparisonResult;
    }
}
