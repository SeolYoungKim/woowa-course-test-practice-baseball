package baseball.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Position {

    private static final Map<Integer, Position> POSITIONS = new HashMap<>();

    static {
        IntStream.rangeClosed(0, 2)
                .forEach(i -> POSITIONS.put(i, new Position(i)));
    }

    static Position of(int value) {
        validateValue(value);
        return POSITIONS.get(value);
    }

    private static void validateValue(int value) {
        if (!POSITIONS.containsKey(value)) {
            throw new IllegalArgumentException("잘못된 포지션 입니다. 0, 1, 2만 가능합니다.");
        }
    }

    private final int value;

    private Position(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
