package baseball;

import baseball.domain.Numbers;
import baseball.domain.Result;
import baseball.service.RandomNumbersGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameMachine {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomNumbersGenerator randomNumbersGenerator;

    public BaseballGameMachine(InputView inputView, OutputView outputView,
            RandomNumbersGenerator randomNumbersGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    public void start() {
        outputView.printGameStart();

        while (true) {
            playGame();
            boolean retry = inputView.inputRetry();

            if (!retry) {
                break;
            }
        }
    }

    private void playGame() {
        Numbers randomNumbers = randomNumbersGenerator.generate();

        while (true) {
            Numbers numbers = inputNumbers();
            Result result = match(numbers, randomNumbers);

            if (result.isSuccess()) {
                outputView.printSuccess();
                break;
            }
        }
    }

    private Numbers inputNumbers() {
        List<Integer> numbers = inputView.inputNumbers();
        return new Numbers(numbers);
    }

    private Result match(Numbers numbers, Numbers randomNumbers) {
        Result result = numbers.match(randomNumbers);
        outputView.printResult(result);

        return result;
    }
}
