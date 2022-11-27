package baseball.view;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @DisplayName("123이 입력되면 리스트 1,2,3가 반환되어야 한다.")
    @Test
    void parseNumbers() {
        InputParser parser = new InputParser();

        List<Integer> numbers = parser.parseNumbers("123");

        Assertions.assertThat(numbers).isEqualTo(List.of(1,2,3));
    }
}