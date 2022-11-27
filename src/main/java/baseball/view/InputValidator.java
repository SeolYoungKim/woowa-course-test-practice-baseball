package baseball.view;

import static baseball.view.InputView.QUIT_COMMAND;
import static baseball.view.InputView.RETRY_COMMAND;

import java.util.List;

public class InputValidator {

    static final String NUMBERS_REGEX = "^[1-9]{3}$";

    void validateNumbers(String numbers) {
        if (!numbers.matches(NUMBERS_REGEX)) {
            throw new IllegalArgumentException("1~9의 숫자 3개 여야 합니다.");
        }
    }

    void validateCommand(String command) {
        if (!List.of(RETRY_COMMAND, QUIT_COMMAND).contains(command)) {
            String message = String.format("%s과 %s만 입력해 주세요", RETRY_COMMAND, QUIT_COMMAND);
            throw new IllegalArgumentException(message);
        }
    }
}
