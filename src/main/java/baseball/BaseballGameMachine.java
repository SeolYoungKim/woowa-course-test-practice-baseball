package baseball;

import baseball.domain.Numbers;
import baseball.service.RandomNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

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

        while (true) {
            playGame();
        }
    }

    private void playGame() {
        Numbers randomNumbers = randomNumbersGenerator.generate();

        Numbers numbers = inputNumbers();

    }

    private Numbers inputNumbers() {
        List<Integer> numbers = inputView.inputNumbers();
        return new Numbers(numbers);
    }


}
