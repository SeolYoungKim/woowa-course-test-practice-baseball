package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    static final String RETRY_COMMAND = "1";
    static final String QUIT_COMMAND = "2";

    private final InputParser inputParser;
    private final InputValidator inputValidator;

    public InputView(InputParser inputParser, InputValidator inputValidator) {
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
    }

    public List<Integer> inputNumbers() {
        print("숫자를 입력해주세요 : ");

        String numbers = inputLine();
        inputValidator.validateNumbers(numbers);

        return inputParser.parseNumbers(numbers);
    }

    public boolean inputRetry() {
        printLine("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요", RETRY_COMMAND, QUIT_COMMAND);

        String command = inputLine();
        inputValidator.validateCommand(command);

        return RETRY_COMMAND.equals(command);
    }

    private void print(String s, Object... args) {
        System.out.printf(s, args);
    }

    private void printLine(String s, Object... args) {
        print(s + "\n", args);
    }

    private String inputLine() {
        return Console.readLine().trim();
    }
}
