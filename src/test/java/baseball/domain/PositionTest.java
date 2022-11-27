package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @ParameterizedTest(name = "{0}이 입력되면 {0} 값을 가진 Position을 반환한다.")
    @ValueSource(ints = {0, 1, 2})
    void ofSuccess(int value) {
        Position actual = Position.of(value);
        assertThat(actual).extracting("value").isEqualTo(value);
    }

    @DisplayName("Position.of()로 반환된 Position은 싱글톤이다.")
    @Test
    void ofSingleton() {
        Position position1 = Position.of(1);
        Position position2 = Position.of(1);
        assertThat(position1).isEqualTo(position2);
    }

    @ParameterizedTest(name = "잘못된 포지션이 입력되면 예외를 발생시킨다. 입력: {0}")
    @ValueSource(ints = {-1, 3, 10})
    void ofFail(int value) {
        assertThatThrownBy(() -> Position.of(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 포지션 입니다. 0, 1, 2만 가능합니다.");
    }
}