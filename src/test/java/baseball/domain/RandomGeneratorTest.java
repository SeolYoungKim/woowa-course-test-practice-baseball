package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

    @Test
    @DisplayName("컴퓨터가 생성한 숫자 사이즈")
    void computerNumber() {
        RandomGenerator randomGenerator = new RandomGenerator();
        List<Integer> computer = randomGenerator.computerNumber();
        int computerNumbers = computer.size();
        assertThat(computerNumbers).isEqualTo(3);

    }
}