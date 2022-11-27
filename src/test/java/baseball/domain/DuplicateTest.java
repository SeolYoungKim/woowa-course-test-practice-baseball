package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateTest {

    @Nested
    class GetDuplicateNumberTest {
        Duplicate duplicate = new Duplicate();

        @DisplayName("중복하는 숫자가 2개 있을때")
        @Test
        void case1() {
            List<Integer> test1 = List.of(1, 2, 3);
            List<Integer> test2 = List.of(2, 3, 4);
            List<Integer> answer = List.of(2, 3);

            assertEquals(answer, duplicate.getDuplicateNumber(test1, test2));
        }

        @DisplayName("중복하는 숫자가 1개 있을때")
        @Test
        void case2() {
            List<Integer> test1 = List.of(1, 2, 3);
            List<Integer> test2 = List.of(3, 4, 5);
            List<Integer> answer = List.of(3);

            assertEquals(answer, duplicate.getDuplicateNumber(test1, test2));
        }

        @DisplayName("중복하는 숫자가 없을때")
        @Test
        void case3() {
            List<Integer> test1 = List.of(1, 2, 3);
            List<Integer> test2 = List.of(4, 5, 6);
            List<Integer> answer = List.of();

            assertEquals(answer, duplicate.getDuplicateNumber(test1, test2));
        }

        @DisplayName("중복하는 숫자가 3개 있을때")
        @Test
        void case4() {
            List<Integer> test1 = List.of(1, 2, 3);
            List<Integer> test2 = List.of(2, 3, 1);
            List<Integer> answer = List.of(1, 2, 3);

            assertEquals(answer, duplicate.getDuplicateNumber(test1, test2));
        }
    }

}