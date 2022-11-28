package baseball.view;

import baseball.domain.ValidateInput;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayerInput {

    private final ValidateInput validateInput;

    public PlayerInput(ValidateInput validateInput) {
        this.validateInput = validateInput;
    }

    public List<Integer> startGameInput() {
        List<Integer> playerNumbers = new ArrayList<>();
        String wordNumber = Console.readLine();

        validateInput.inputValidation(wordNumber);
        inputDivision(playerNumbers, wordNumber);
        return playerNumbers;
    }

    private void inputDivision(List<Integer> player, String wordNumber) {
        for (String word : wordNumber.split("")) {
            player.add(Integer.parseInt(word));
        }
    }

    public int restartGameInput() {
        String wordNumber = Console.readLine();
        validateInput.inputRestartValidation(wordNumber);
        return Integer.parseInt(wordNumber);
    }
}
