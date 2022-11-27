package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValueConverterTest {

    private final InputValueConverter inputValueConverter = new InputValueConverter();

    @DisplayName("문자열을 입력 받았을 때")
    @Nested
    class test1 {

        @ParameterizedTest(name = "세 자리의 숫자면 List<Integer>를 반환한다. 입력: {0}")
        @ValueSource(strings = {"123", "111", "987"})
        void convertSuccess(String inputValue) {
            List<Integer> actual = inputValueConverter.inputValueToList(inputValue);
            assertThat(actual).hasSize(3);
        }

        @ParameterizedTest(name = "숫자로만 구성되지 않았다면 예외를 발생시킨다. 입력: {0}")
        @ValueSource(strings = {"", "11j", "hi!"})
        void convertFailBecauseNumber(String inputValue) {
            assertThatThrownBy(() -> inputValueConverter.inputValueToList(inputValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자만 입력해 주세요.");
        }

        @ParameterizedTest(name = "세 자리가 아니면 예외를 발생시킨다. 입력: {0}")
        @ValueSource(strings = {"12345", "11", "1"})
        void convertFailBecauseLength(String inputValue) {
            assertThatThrownBy(() -> inputValueConverter.inputValueToList(inputValue))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("세 자리 숫자만 입력해 주세요.");
        }
    }
}