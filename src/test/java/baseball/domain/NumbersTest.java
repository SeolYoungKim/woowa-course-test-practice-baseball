package baseball.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Nested
    class CreateTest {

        @DisplayName("4개의 숫자가 주어졌을 때, 예외를 발생시켜야 한다.")
        @Test
        void createFailWithInvalidSize() {
            List<Number> numberList = List.of(new Number(1), new Number(2), new Number(3), new Number(4));

            Assertions.assertThatThrownBy(() -> new Numbers(numberList))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자는 3개여야 합니다.");
        }

        @DisplayName("중복된 숫자가 주어졌을 때, 예외를 발생시켜야 한다.")
        @Test
        void createFailWithDuplicateNumbers() {
            List<Number> numberList = List.of(new Number(1), new Number(3), new Number(3));

            Assertions.assertThatThrownBy(() -> new Numbers(numberList))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자는 중복되지 않아야 합니다.");
        }

        @DisplayName("알맞은 숫자가 주어졌을 때, 예외가 발생하지 않아야 한다.")
        @Test
        void createSuccess() {
            List<Number> numberList = List.of(new Number(1), new Number(2), new Number(3));

            Numbers ignoredNumbers = new Numbers(numberList);
        }
    }

    @Nested
    class MatchTest {

        @DisplayName("1,2,3과 4,5,6을 비교했을때, 0스트라이크, 0볼이 나와야 한다.")
        @Test
        void matchNothing() {
            Numbers numbers1 = new Numbers(List.of(new Number(1), new Number(2), new Number(3)));
            Numbers numbers2 = new Numbers(List.of(new Number(4), new Number(5), new Number(6)));

            Result result = numbers1.match(numbers2);
            int strike = result.strike();
            int ball = result.ball();

            Assertions.assertThat(strike).isEqualTo(0);
            Assertions.assertThat(ball).isEqualTo(0);
        }

        @DisplayName("1,2,3과 1,2,3을 비교했을때, 3스트라이크, 0볼이 나와야 한다.")
        @Test
        void match3Strike() {
            Numbers numbers1 = new Numbers(List.of(new Number(1), new Number(2), new Number(3)));
            Numbers numbers2 = new Numbers(List.of(new Number(1), new Number(2), new Number(3)));

            Result result = numbers1.match(numbers2);
            int strike = result.strike();
            int ball = result.ball();

            Assertions.assertThat(strike).isEqualTo(3);
            Assertions.assertThat(ball).isEqualTo(0);
        }

        @DisplayName("1,2,3과 3,1,2을 비교했을때, 0스트라이크, 3볼이 나와야 한다.")
        @Test
        void match3Ball() {
            Numbers numbers1 = new Numbers(List.of(new Number(1), new Number(2), new Number(3)));
            Numbers numbers2 = new Numbers(List.of(new Number(3), new Number(1), new Number(2)));

            Result result = numbers1.match(numbers2);
            int strike = result.strike();
            int ball = result.ball();

            Assertions.assertThat(strike).isEqualTo(0);
            Assertions.assertThat(ball).isEqualTo(3);
        }
    }
}