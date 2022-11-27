package baseball.domain;

import java.util.List;

public class BaseballNumbers {

    private final List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateSize(baseballNumbers);
        validateDuplication(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    public ComparisonResult comparisonResult(BaseballNumbers other) {
        int strikeCount = strikeCount(other);
        int ballCount = ballCount(other);

        return new ComparisonResult(strikeCount, ballCount);
    }

    private int strikeCount(BaseballNumbers other) {
        return (int) baseballNumbers.stream()
                .filter(other::contains)
                .count();
    }

    private boolean contains(BaseballNumber baseballNumber) {
        return baseballNumbers.contains(baseballNumber);
    }

    private int ballCount(BaseballNumbers other) {
        return (int) baseballNumbers.stream()
                .filter(baseballNumber -> baseballNumber.isBall(other.baseballNumbers))
                .count();
    }

    private void validateSize(List<BaseballNumber> baseballNumbers) {
        final int MAX_SIZE_FOR_THIS_GAME = 3;
        if (baseballNumbers.size() != MAX_SIZE_FOR_THIS_GAME) {
            throw new IllegalArgumentException("세 자리 숫자만 입력해 주세요.");
        }
    }

    private void validateDuplication(List<BaseballNumber> baseballNumbers) {
        for (BaseballNumber baseballNumber : baseballNumbers) {
            if (baseballNumber.isDuplicatedIn(baseballNumbers)) {
                throw new IllegalArgumentException("중복된 숫자는 입력될 수 없습니다.");
            }
        }
    }
}
