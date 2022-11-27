package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValueConverter {

    public List<Integer> inputValueToList(String inputValue) {
        validateThisIsNumber(inputValue);

        return Arrays.stream(inputValue.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void validateThisIsNumber(String inputValue) {
        final String REGEX_FOR_NUMBER = "^\\d+$";
        if (!inputValue.matches(REGEX_FOR_NUMBER)) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }
}
