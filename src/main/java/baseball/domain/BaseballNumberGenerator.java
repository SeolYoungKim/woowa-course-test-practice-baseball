package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumberGenerator {

    private final InputValueConverter inputValueConverter;

    public BaseballNumberGenerator(InputValueConverter inputValueConverter) {
        this.inputValueConverter = inputValueConverter;
    }

    public BaseballNumbers listToBaseballNumbers(String inputValue) {
        List<Integer> numbers = inputValueConverter.inputValueToList(inputValue);

        return new BaseballNumbers(
                numbers.stream()
                        .map(number -> new BaseballNumber(numbers.indexOf(number), number))
                        .collect(Collectors.toList()));
    }
}
