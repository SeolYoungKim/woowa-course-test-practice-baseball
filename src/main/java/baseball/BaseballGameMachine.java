package baseball;

import baseball.service.RandomNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameMachine {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumbersGenerator randomNumbersGenerator;

    public BaseballGameMachine(InputView inputView, OutputView outputView, RandomNumbersGenerator randomNumbersGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    public void start() {
        outputView.printGameStart();

    }

}
