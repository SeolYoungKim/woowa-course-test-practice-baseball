package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Nested
class JudgementTest {
    Judgement judgement = new Judgement(new Duplicate());

    @DisplayName("볼의 갯수가 3개일때")
    @Test
    void case1() {
        List<Integer> test1 = List.of(1, 2, 3);
        List<Integer> test2 = List.of(2, 3, 1);
        int strikeAnswer = 0;
        int ballAnswer = 3;
        assertEquals(strikeAnswer, judgement.strike(test1, test2));
        assertEquals(ballAnswer, judgement.ball(test1, test2));
    }

    @DisplayName("스트라이크 갯수가 1개, 볼의 갯수가 2개일때")
    @Test
    void case2() {
        List<Integer> test1 = List.of(1, 2, 3);
        List<Integer> test2 = List.of(3, 2, 1);
        int strikeAnswer = 1;
        int ballAnswer = 2;
        assertEquals(strikeAnswer, judgement.strike(test1, test2));
        assertEquals(ballAnswer, judgement.ball(test1, test2));
    }

    @DisplayName("스트라이크 갯수가 3개일 때")
    @Test
    void case3() {
        List<Integer> test1 = List.of(1, 2, 3);
        List<Integer> test2 = List.of(1, 2, 3);
        int strikeAnswer = 3;
        int ballAnswer = 0;
        assertEquals(strikeAnswer, judgement.strike(test1, test2));
        assertEquals(ballAnswer, judgement.ball(test1, test2));
    }

    @DisplayName("스트라이크 갯수가 1개, 볼의 갯수가 0개일 때")
    @Test
    void case4() {
        List<Integer> test1 = List.of(1, 2, 3);
        List<Integer> test2 = List.of(1, 4, 5);
        int strikeAnswer = 1;
        int ballAnswer = 0;
        assertEquals(strikeAnswer, judgement.strike(test1, test2));
        assertEquals(ballAnswer, judgement.ball(test1, test2));
    }

    @DisplayName("스트라이크 갯수가 2개, 볼의 갯수가 0개일 때")
    @Test
    void case5() {
        List<Integer> test1 = List.of(1, 2, 3);
        List<Integer> test2 = List.of(1, 2, 4);
        int strikeAnswer = 2;
        int ballAnswer = 0;
        assertEquals(strikeAnswer, judgement.strike(test1, test2));
        assertEquals(ballAnswer, judgement.ball(test1, test2));
    }

    @DisplayName("스트라이크 갯수와 볼의 갯수가 0개일 때 ")
    @Test
    void case6() {
        List<Integer> test1 = List.of(1, 2, 3);
        List<Integer> test2 = List.of(4, 5, 6);
        int strikeAnswer = 0;
        int ballAnswer = 0;
        assertEquals(strikeAnswer, judgement.strike(test1, test2));
        assertEquals(ballAnswer, judgement.ball(test1, test2));
    }


}