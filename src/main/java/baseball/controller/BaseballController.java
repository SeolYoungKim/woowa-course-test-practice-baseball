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

        outputView.printGameEndMessage();
    }

    private void gameStart() {
        BaseballNumbers computerNumbers = baseballNumbersGenerator.randomNumbersForComputer();
        BaseballGame baseballGame = new BaseballGame();

        while (!baseballGame.isEnd()) {
            ComparisonResult comparisonResult = inputAndComparison(computerNumbers);
            checkComparisonResult(baseballGame, comparisonResult);

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

    private void checkComparisonResult(BaseballGame baseballGame, ComparisonResult comparisonResult) {
        if (comparisonResult.isThreeStrike()) {
            inputCommandForRestartOrQuit(baseballGame);
        }
    }

    private void inputCommandForRestartOrQuit(BaseballGame baseballGame) {
        outputView.printCorrectAnswerMessage();
        baseballGame.setGameCommand(inputView.restartOrQuit());
    }
}
