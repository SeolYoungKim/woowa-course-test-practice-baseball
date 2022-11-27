package baseball.controller;

import baseball.domain.BaseballGame;
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
        BaseballGame baseballGame = new BaseballGame();

        while (!baseballGame.isEnd()) {
            ComparisonResult comparisonResult = inputAndComparison(computerNumbers);
            if (comparisonResult.isThreeStrike()) {
                restartOrQuit(baseballGame);
            }

            if (baseballGame.isRestart()) {
                computerNumbers = baseballNumbersGenerator.randomNumbersForComputer();
                baseballGame.restart();
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

    private void restartOrQuit(BaseballGame baseballGame) {
        outputView.printEndMessage();
        baseballGame.setGameCommand(inputView.restartOrQuit());
    }
}
