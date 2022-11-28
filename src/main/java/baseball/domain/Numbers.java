package baseball.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Numbers {

    public final static int NUMBERS_SIZE = 3;
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        validateNumbersSize(numbers);
        validateNumbersUnique(numbers);

        this.numbers = List.copyOf(numbers);
    }

    private void validateNumbersSize(List<Number> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                    String.format("숫자는 %d개여야 합니다.", NUMBERS_SIZE));
        }
    }

    private void validateNumbersUnique(List<Number> numbers) {
        int distinctSize = (int) numbers.stream().distinct().count();

        if (distinctSize != numbers.size()) {
            throw new IllegalArgumentException("숫자는 중복되지 않아야 합니다.");
        }
    }

    public Result match(Numbers other) {
        int ball = matchBall(other);
        int strike = matchStrike(other);

        return new Result(ball, strike);
    }

    private int matchStrike(Numbers other) {
        return (int) IntStream.range(0, NUMBERS_SIZE)
                .filter(i -> Objects.equals(numbers.get(i), other.numbers.get(i)))
                .count();
    }

    private int matchBall(Numbers other) {
        int ball = (int) other.numbers.stream()
                .filter(numbers::contains)
                .count();

        return ball - matchStrike(other);
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
