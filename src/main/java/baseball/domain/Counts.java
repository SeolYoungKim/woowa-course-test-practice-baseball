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

    static Counts of(int counts) {
        return COUNTS.get(counts);
    }

    private final int value;

    public Counts(int value) {
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
