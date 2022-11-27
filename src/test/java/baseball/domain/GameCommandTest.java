package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

    @ParameterizedTest(name = "1 또는 2가 아닌 값을 입력하면 예외를 발생시킨다. 입력: {0}")
    @ValueSource(strings = {"0", "4", "123", "a"})
    void ofFail(String inputValue) {
        assertThatThrownBy(() -> GameCommand.of(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2만 입력해 주세요. 재시작: 1 | 종료: 2");
    }
}