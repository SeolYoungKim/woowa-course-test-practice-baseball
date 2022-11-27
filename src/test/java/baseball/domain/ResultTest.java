package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Nested
    class IsNothingTest {

        @DisplayName("0볼 0스트라이크인 경우 낫싱이여야 한다.")
        @Test
        void nothingTrue() {
            Result result = new Result(0, 0);

            boolean nothing = result.isNothing();

            Assertions.assertThat(nothing).isEqualTo(true);
        }

        @DisplayName("0볼 2스트라이크인 경우 낫싱이 아니여야 한다.")
        @Test
        void nothingFalse() {
            Result result = new Result(0, 2);

            boolean nothing = result.isNothing();

            Assertions.assertThat(nothing).isEqualTo(false);
        }
    }

    @Nested
    class IsSuccessTest {

        @DisplayName("0볼 3스트라이크인 경우 성공이여야 한다.")
        @Test
        void successTrue() {
            Result result = new Result(0, 3);

            boolean success = result.isSuccess();

            Assertions.assertThat(success).isEqualTo(true);
        }

        @DisplayName("1볼 2스트라이크인 경우 성공이 아니여야 한다.")
        @Test
        void successFalse() {
            Result result = new Result(1, 2);

            boolean success = result.isSuccess();

            Assertions.assertThat(success).isEqualTo(false);
        }
    }
}