package baseball.domain;

public class Number {

    public static final int NUMBER_MIN_INCLUSIVE = 1;
    public static final int NUMBER_MAX_INCLUSIVE = 9;

    private final int number;

    public Number(int number) {
        validateNumberRange(number);

        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (NUMBER_MIN_INCLUSIVE > number || number > NUMBER_MAX_INCLUSIVE) {
            throw new IllegalArgumentException("숫자는 1~9사이의 값이여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Number number1 = (Number) o;

        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }
}
