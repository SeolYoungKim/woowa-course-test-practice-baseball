package baseball;

import baseball.controll.GameController;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.view.TypeChange;
import baseball.view.Verification;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(new Verification(), new TypeChange()), new OutputView());

        gameController.startGame();
    }
}
