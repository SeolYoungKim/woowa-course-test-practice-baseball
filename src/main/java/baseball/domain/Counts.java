package baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Counts {

    private static final Map<Integer, Counts> COUNTS = new HashMap<>();

    static {
        IntStream.rangeClosed(0, 3)
                .forEach(i -> COUNTS.put(i, new Counts(i)));
    }

    static Counts of(int value) {
        validateValue(value);
        return COUNTS.get(value);
    }

    private static void validateValue(int value) {
        if (!COUNTS.containsKey(value)) {
            throw new IllegalArgumentException("잘못된 카운트 입니다. 0이상 3이하의 수만 입력해 주세요.");
        }
    }

    private final int value;

    private Counts(int value) {
        this.value = value;
    }

    boolean isZero() {
        return value == 0;
    }

    boolean isMoreThanOne() {
        return 1 <= value;
    }

    boolean isThree() {
        return value == 3;
    }

    int value() {
        return value;
    }
}
