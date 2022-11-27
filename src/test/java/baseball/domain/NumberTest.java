package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @DisplayName("범위가 벗어난 경우 생성할때 예외가 발생해야 한다.")
    @Nested
    class CreateFailWithOutOfRange {

        @ValueSource(ints = {0,10})
        @ParameterizedTest()
        void test(int number) {
            Assertions.assertThatThrownBy(() -> new Number(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자는 1~9사이의 값이여야 합니다.");
        }
    }

    @DisplayName("잘 생성된 경우")
    @Nested
    class CreateSuccess {

        @ValueSource(ints = {1,4,9})
        @ParameterizedTest()
        void test(int number) {
            Number ignoredNumber = new Number(number);
        }
    }
}