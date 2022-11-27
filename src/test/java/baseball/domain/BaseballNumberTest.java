package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballNumberTest {

    @DisplayName("BaseballNumber를 생성할 때")
    @Nested
    class construct {

        @ParameterizedTest(name = "position 값이 0, 1, 2가 아니면 예외를 발생시킨다. 입력: {0}")
        @CsvSource({"-1,1", "3,2", "999,3"})
        void constructFailBecausePosition(String position, String number) {
            assertThatThrownBy(() ->
                    new BaseballNumber(Integer.parseInt(position), Integer.parseInt(number)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 포지션 입니다. 0, 1, 2만 가능합니다.");
        }

        @ParameterizedTest(name = "number가 1~9 사이의 값이 아니면 예외를 발생시킨다. 입력: {1}")
        @CsvSource({"0,-1", "1,0", "2,10"})
        void constructFailBecauseNumber(String position, String number) {
            assertThatThrownBy(() ->
                    new BaseballNumber(Integer.parseInt(position), Integer.parseInt(number)))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자는 1~9만 입력할 수 있습니다.");
        }
    }

    @DisplayName("자기 자신이 List<BaseballNumber>내에서 Ball인지에 대한 여부를 판단한다.")
    @Nested
    class isBall {

        @DisplayName("Ball이면 true를 반환한다.")
        @Test
        void checkBallTrue() {
            BaseballNumber baseballNumber = new BaseballNumber(0, 1);
            List<BaseballNumber> oneBallCase = List.of(new BaseballNumber(0, 2),
                    new BaseballNumber(1, 1),
                    new BaseballNumber(2, 3));

            assertThat(baseballNumber.isBall(oneBallCase)).isTrue();
        }

        @DisplayName("Ball이 아니면 false를 반환한다.")
        @Test
        void checkBallFalse() {
            BaseballNumber baseballNumber = new BaseballNumber(0, 1);
            List<BaseballNumber> noneOfBallCase = List.of(new BaseballNumber(0, 1),
                    new BaseballNumber(1, 2),
                    new BaseballNumber(2, 3));

            assertThat(baseballNumber.isBall(noneOfBallCase)).isFalse();
        }
    }
    @DisplayName("자기 자신이 List<BaseballNumber>내에서 중복되는지에 대한 여부를 판단한다.")
    @Nested
    class isDuplicatedIn {

        @DisplayName("자기 자신과 다르지만, 숫자가 중복되면 true를 반환한다.")
        @Test
        void checkDuplicationTrue() {
            BaseballNumber baseballNumber = new BaseballNumber(0, 1);
            List<BaseballNumber> oneDuplicationCase = List.of(
                    new BaseballNumber(0, 1),
                    new BaseballNumber(1, 1),
                    new BaseballNumber(2, 3));

            assertThat(baseballNumber.isDuplicatedIn(oneDuplicationCase)).isTrue();
        }

        @DisplayName("숫자가 중복되지 않으면 false를 반환한다.")
        @Test
        void checkDuplicationFalse() {
            BaseballNumber baseballNumber = new BaseballNumber(0, 1);
            List<BaseballNumber> noneDuplicationCase = List.of(
                    new BaseballNumber(0, 1),
                    new BaseballNumber(1, 2),
                    new BaseballNumber(2, 3));

            assertThat(baseballNumber.isDuplicatedIn(noneDuplicationCase)).isFalse();
        }

    }
}