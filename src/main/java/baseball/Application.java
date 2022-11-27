package baseball;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(new Verification(), new TypeChange()), new OutputView());

        gameController.startGame();
    }
}
