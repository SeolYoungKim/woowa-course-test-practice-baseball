package baseball;

import baseball.controller.BaseballController;
import baseball.domain.BaseballNumbersGenerator;
import baseball.domain.InputValueConverter;
import baseball.domain.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.OutputViewFormatter;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView(new OutputViewFormatter());
        BaseballNumbersGenerator baseballNumbersGenerator = new BaseballNumbersGenerator(
                new InputValueConverter(),
                new RandomNumberGenerator());

        BaseballController baseballController = new BaseballController(inputView, outputView,
                baseballNumbersGenerator);

        baseballController.run();
    }
}
