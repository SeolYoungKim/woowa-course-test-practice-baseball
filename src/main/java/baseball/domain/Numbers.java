package baseball.domain;

import java.util.List;
import java.util.Objects;

public class Numbers {

    public final static int NUMBER_COUNT = 3;
    public static final int NUMBER_MIN_INCLUSIVE = 1;
    public static final int NUMBER_MAX_INCLUSIVE = 9;
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersRange(numbers);
        validateNumbersUnique(numbers);

        this.numbers = List.copyOf(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("숫자는 %d개여야 합니다.", NUMBER_COUNT));
        }
    }

    private void validateNumbersUnique(List<Integer> numbers) {
        int distinctSize = (int) numbers.stream().distinct().count();

        if (distinctSize != numbers.size()) {
            throw new IllegalArgumentException("숫자는 중복되지 않아야 합니다.");
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(int number) {
        if (NUMBER_MIN_INCLUSIVE > number || number > NUMBER_MAX_INCLUSIVE) {
            throw new IllegalArgumentException("숫자는 1~9사이의 값이여야 합니다.");
        }
    }

    public List<Integer> numbers() {
        return List.copyOf(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Numbers numbers1 = (Numbers) o;

        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}
