package baseball;

import baseball.service.RandomNumbersGenerator;
import baseball.view.InputParser;
import baseball.view.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputFormatter;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine(
                inputView(), outputView(), new RandomNumbersGenerator());

        baseballGameMachine.start();
    }

    private static InputView inputView() {
        return new InputView(
                new InputParser(), new InputValidator());
    }

    private static OutputView outputView() {
        return new OutputView(new OutputFormatter());
    }
}
