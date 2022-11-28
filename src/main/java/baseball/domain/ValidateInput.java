package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class ValidateInput {
    private static final String REGULAR_PATTERN = "[1-9]+";
    private static final String PATTERN = "[1-2]+";

    public void validateInputSize(String input) {
        int length = input.length();
        if (!(length == 3)) {
            throw new IllegalArgumentException("세자리 숫자가 아닙니다.");
        }
    }

    public void validateDuplicate(String input) {
        String[] split = input.split("");
        HashSet<String> verification = new HashSet<>(List.of(split));

        if (verification.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    public void validateZero(String input) {
        for (char word : input.toCharArray()) {
            if (word == '0') {
                throw new IllegalArgumentException("0이 포함되어 있습니다.");
            }
        }
    }

    public void validateCharacter(String input) {
        if (!(input.matches(REGULAR_PATTERN))) {
            throw new IllegalArgumentException("문자를 입력하였습니다.");
        }
    }

    public void inputValidation(String input) {
        validateInputSize(input);
        validateDuplicate(input);
        validateZero(input);
        validateCharacter(input);
    }

    public void validateBetween(String input) {
        if (input.equals('1') || input.equals('2')) {
            throw new IllegalArgumentException("1, 2가 아닌 다른값을 입력 하였습니다.");
        }
    }

    public void validateRestartCharacter(String input) {
        if (!(input.matches(PATTERN))) {
            throw new IllegalArgumentException("문자를 입력하였습니다.");
        }
    }

    public void inputRestartValidation(String input) {
        validateBetween(input);
        validateRestartCharacter(input);
    }
}
