package baseball.view;

import baseball.domain.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OutputFormatterTest {

    @Nested
    class FormatResultTest {

        @DisplayName("낫싱인 경우 '낫싱'을 반환해야 한다.")
        @Test
        void nothing() {
            OutputFormatter formatter = new OutputFormatter();
            Result result = new Result(0, 0);

            String string = formatter.formatResult(result);
            Assertions.assertThat(string).isEqualTo("낫싱");
        }

        @DisplayName("1스트라이크인 2볼인 경우 '2볼 1스트라이크'를 반환해야 한다.")
        @Test
        void strike1ball2() {
            OutputFormatter formatter = new OutputFormatter();
            Result result = new Result(2, 1);

            String string = formatter.formatResult(result);
            Assertions.assertThat(string).isEqualTo("2볼 1스트라이크");
        }

        @DisplayName("2볼인 경우 '2볼'를 반환해야 한다.")
        @Test
        void ball2() {
            OutputFormatter formatter = new OutputFormatter();
            Result result = new Result(2, 0);

            String string = formatter.formatResult(result);
            Assertions.assertThat(string).isEqualTo("2볼");
        }

        @DisplayName("2스트라이크인 경우 '2스크라이크'를 반환해야 한다.")
        @Test
        void strike2() {
            OutputFormatter formatter = new OutputFormatter();
            Result result = new Result(0, 2);

            String string = formatter.formatResult(result);
            Assertions.assertThat(string).isEqualTo("2스트라이크");
        }
    }
}