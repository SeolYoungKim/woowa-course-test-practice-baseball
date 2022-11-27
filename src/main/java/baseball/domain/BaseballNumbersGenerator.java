package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseballNumbersGenerator {

    private final InputValueConverter inputValueConverter;
    private final RandomNumberGenerator randomNumberGenerator;

    public BaseballNumbersGenerator(InputValueConverter inputValueConverter,
            RandomNumberGenerator randomNumberGenerator) {
        this.inputValueConverter = inputValueConverter;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public BaseballNumbers baseballNumbers(String inputValue) {
        List<Integer> numbers = inputValueConverter.inputValueToList(inputValue);
        return integerListToBaseballNumbers(numbers);
    }

    public BaseballNumbers randomNumbersForComputer() {
        List<Integer> randomNumbers = randomNumberGenerator.randomNumbers();
        return integerListToBaseballNumbers(randomNumbers);
    }

    private BaseballNumbers integerListToBaseballNumbers(List<Integer> numbers) {
        return new BaseballNumbers(
                IntStream.range(0, numbers.size())
                        .mapToObj(i -> new BaseballNumber(Position.of(i), numbers.get(i)))
                        .collect(Collectors.toList()));
    }

}
