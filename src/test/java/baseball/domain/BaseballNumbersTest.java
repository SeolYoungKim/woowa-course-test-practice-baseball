package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballNumbersTest {

    @ParameterizedTest(name = "생성 시 List의 size가 3이 아니면 예외를 발생시킨다.")
    @MethodSource("listForValidateSize")
    void constructFailBecauseSize(List<BaseballNumber> baseballNumbers) {
        assertThatThrownBy(() -> new BaseballNumbers(baseballNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세 자리 숫자만 입력해 주세요.");
    }


    static Stream<Arguments> listForValidateSize() {
        return Stream.of(
                Arguments.of(List.of(
                        new BaseballNumber(Position.of(0), 1),
                        new BaseballNumber(Position.of(1), 2)
                )),
                Arguments.of(List.of(
                        new BaseballNumber(Position.of(0), 1),
                        new BaseballNumber(Position.of(1), 2),
                        new BaseballNumber(Position.of(2), 3),
                        new BaseballNumber(Position.of(2), 4)
                ))
        );
    }

    @ParameterizedTest(name = "생성 시 중복 숫자가 포함되었을 경우 예외를 발생시킨다.")
    @MethodSource("listForValidateDuplication")
    void constructFailBecauseDuplication(List<BaseballNumber> baseballNumbers) {
        assertThatThrownBy(() -> new BaseballNumbers(baseballNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자는 입력될 수 없습니다.");
    }

    static Stream<Arguments> listForValidateDuplication() {
        return Stream.of(
                Arguments.of(List.of(
                        new BaseballNumber(Position.of(0), 1),
                        new BaseballNumber(Position.of(1), 2),
                        new BaseballNumber(Position.of(2), 2)
                )),
                Arguments.of(List.of(
                        new BaseballNumber(Position.of(0), 1),
                        new BaseballNumber(Position.of(1), 1),
                        new BaseballNumber(Position.of(2), 1)
                ))
        );
    }

    @DisplayName("비교할 BaseballNumbers를 받았을 때")
    @Nested
    class comparisonResult {

        private BaseballNumbers baseballNumbers;

        @BeforeEach
        void setUp() {
            baseballNumbers = new BaseballNumbers(List.of(
                    new BaseballNumber(Position.of(0), 1),
                    new BaseballNumber(Position.of(1), 2),
                    new BaseballNumber(Position.of(2), 3)
            ));
        }

        @DisplayName("3스트라이크를 반환하는 경우")
        @Test
        void threeStrikeCase() {
            BaseballNumbers target = new BaseballNumbers(List.of(
                    new BaseballNumber(Position.of(0), 1),
                    new BaseballNumber(Position.of(1), 2),
                    new BaseballNumber(Position.of(2), 3)
            ));
            ComparisonResult comparisonResult = baseballNumbers.comparisonResult(target);
            assertThat(comparisonResult.strikeCount()).isEqualTo(3);
            assertThat(comparisonResult.ballCount()).isEqualTo(0);
        }

        @DisplayName("1스트라이크 2볼을 반환하는 경우")
        @Test
        void oneStrikeTwoBallCase() {
            BaseballNumbers target = new BaseballNumbers(List.of(
                    new BaseballNumber(Position.of(0), 1),
                    new BaseballNumber(Position.of(1), 3),
                    new BaseballNumber(Position.of(2), 2)
            ));
            ComparisonResult comparisonResult = baseballNumbers.comparisonResult(target);
            assertThat(comparisonResult.strikeCount()).isEqualTo(1);
            assertThat(comparisonResult.ballCount()).isEqualTo(2);
        }

        @DisplayName("3볼을 반환하는 경우")
        @Test
        void threeBallCase() {
            BaseballNumbers target = new BaseballNumbers(List.of(
                    new BaseballNumber(Position.of(0), 2),
                    new BaseballNumber(Position.of(1), 3),
                    new BaseballNumber(Position.of(2), 1)
            ));
            ComparisonResult comparisonResult = baseballNumbers.comparisonResult(target);
            assertThat(comparisonResult.strikeCount()).isEqualTo(0);
            assertThat(comparisonResult.ballCount()).isEqualTo(3);
        }

        @DisplayName("아무것도 맞추지 못한 경우")
        @Test
        void nothingCase() {
            BaseballNumbers target = new BaseballNumbers(List.of(
                    new BaseballNumber(Position.of(0), 9),
                    new BaseballNumber(Position.of(1), 7),
                    new BaseballNumber(Position.of(2), 8)
            ));
            ComparisonResult comparisonResult = baseballNumbers.comparisonResult(target);
            assertThat(comparisonResult.strikeCount()).isEqualTo(0);
            assertThat(comparisonResult.ballCount()).isEqualTo(0);
        }
    }
}