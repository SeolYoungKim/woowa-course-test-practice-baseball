package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CountsTest {
    @ParameterizedTest(name = "{0}이 입력되면 {0} 값을 가진 Counts를 반환한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void ofSuccess(int value) {
        Counts actual = Counts.of(value);
        assertThat(actual.value()).isEqualTo(value);
    }

    @DisplayName("Counts.of()로 반환된 Counts은 싱글톤이다.")
    @Test
    void ofSingleton() {
        Counts counts1 = Counts.of(1);
        Counts counts2 = Counts.of(1);
        assertThat(counts1).isEqualTo(counts2);
    }

    @ParameterizedTest(name = "잘못된 카운트가 입력되면 예외를 발생시킨다. 입력: {0}")
    @ValueSource(ints = {-1, 4, 10})
    void ofFail(int value) {
        assertThatThrownBy(() -> Counts.of(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 카운트 입니다. 0이상 3이하의 수만 입력해 주세요.");
    }
}