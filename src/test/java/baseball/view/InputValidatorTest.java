package baseball.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Nested
    class ValidateNumbersTest {

        @DisplayName("123이 주어졌을 때, 예외가 발생하지 않아야 한다.")
        @Test
        void success() {
            InputValidator validator = new InputValidator();
            String numbers = "123";

            validator.validateNumbers(numbers);
        }

        @DisplayName("숫자가 아닌 값이 주어졌을 때, 예외가 발생해야 한다.")
        @Test
        void failWithNonNumbers() {
            InputValidator validator = new InputValidator();
            String numbers = "AAA";

            Assertions.assertThatThrownBy(() -> validator.validateNumbers(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("1~9의 숫자 3개 여야 합니다.");
        }

        @DisplayName("1~9범위가 아닌 0이 주어졌을 때, 예외가 발생해야 한다.")
        @Test
        void failWithOutOfRange() {
            InputValidator validator = new InputValidator();
            String numbers = "000";

            Assertions.assertThatThrownBy(() -> validator.validateNumbers(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("1~9의 숫자 3개 여야 합니다.");
        }

        @DisplayName("1234이 주어졌을 때, 예외가 발생해야 한다.")
        @Test
        void failWithInvalidCount() {
            InputValidator validator = new InputValidator();
            String numbers = "1234";

            Assertions.assertThatThrownBy(() -> validator.validateNumbers(numbers))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("1~9의 숫자 3개 여야 합니다.");
        }
    }

    @Nested
    class ValidateCommandTest {

        @ValueSource(strings = {"1", "2"})
        @ParameterizedTest(name = "{argumentsWithNames}가 주어졌을 때 성공")
        void success(String command) {
            InputValidator validator = new InputValidator();

            validator.validateCommand(command);
        }

        @DisplayName("1,2이 아닌 다른 값이 주어졌을 때 예외가 발생해야 한다.")
        @Test
        void fail() {
            InputValidator validator = new InputValidator();
            String command = "A";

            Assertions.assertThatThrownBy(() -> validator.validateCommand(command))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("1과 2만 입력해 주세요");
        }
    }
}