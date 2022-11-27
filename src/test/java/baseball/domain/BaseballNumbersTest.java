package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
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
                        new BaseballNumber(0, 1),
                        new BaseballNumber(1, 2)
                )),
                Arguments.of(List.of(
                        new BaseballNumber(0, 1),
                        new BaseballNumber(1, 2),
                        new BaseballNumber(2, 3),
                        new BaseballNumber(3, 4)
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
                        new BaseballNumber(0, 1),
                        new BaseballNumber(1, 2),
                        new BaseballNumber(2, 2)
                )),
                Arguments.of(List.of(
                        new BaseballNumber(0, 1),
                        new BaseballNumber(1, 1),
                        new BaseballNumber(2, 1)
                ))
        );
    }

}