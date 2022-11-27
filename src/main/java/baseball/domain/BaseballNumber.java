package baseball.domain;

import java.util.List;
import java.util.Objects;

public class BaseballNumber {
    private final int position;
    private final int number;

    public BaseballNumber(int position, int number) {
        validateRangeOfPosition(position);
        validateRangeOfNumber(number);

        this.position = position;
        this.number = number;
    }

    public boolean isBall(List<BaseballNumber> baseballNumbers) {
        return baseballNumbers.stream()
                .anyMatch(baseballNumber -> baseballNumber.isBall(this));
    }

    private boolean isBall(BaseballNumber other) {
        return position != other.position &&
                number == other.number;
    }

    public boolean isDuplicatedIn(List<BaseballNumber> baseballNumbers) {
        return baseballNumbers.stream()
                .anyMatch(this::isDuplicated);
    }

    private boolean isDuplicated(BaseballNumber baseballNumber) {
        return !baseballNumber.equals(this) &&
                baseballNumber.number == this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballNumber that = (BaseballNumber) o;
        return position == that.position && number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

    private void validateRangeOfPosition(int position) {
        final int MIN_VALUE_FOR_POSITION = 0;
        final int MAX_VALUE_FOR_POSITION = 2;
        if (position < MIN_VALUE_FOR_POSITION || MAX_VALUE_FOR_POSITION < position) {
            throw new IllegalArgumentException("잘못된 포지션 입니다. 0, 1, 2만 가능합니다.");
        }
    }

    private void validateRangeOfNumber(int number) {
        final int MIN_VALUE_FOR_NUMBER = 1;
        final int MAX_VALUE_FOR_NUMBER = 9;
        if (number < MIN_VALUE_FOR_NUMBER || MAX_VALUE_FOR_NUMBER < number) {
            throw new IllegalArgumentException("숫자는 1~9만 입력할 수 있습니다.");
        }
    }
}
