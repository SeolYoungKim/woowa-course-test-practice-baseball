package baseball;

import baseball.controller.BaseballMachine;
import baseball.domain.ValidateInput;
import baseball.view.PlayerInput;
import baseball.view.PlayerOutput;

public class Application {
    public static void main(String[] args) {
        BaseballMachine baseballMachine = new BaseballMachine(
                new PlayerInput(new ValidateInput()),
                new PlayerOutput());
        baseballMachine.run();
    }
}
