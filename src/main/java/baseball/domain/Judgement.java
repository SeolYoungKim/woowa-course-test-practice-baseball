package baseball;

import java.util.List;

public class Judgement {

    Duplicate duplicate;

    Judgement(Duplicate duplicate) {
        this.duplicate = duplicate;
    }

    public int strike(List<Integer> answerNumbers, List<Integer> player) {
        int strike = 0;
        for (int overlapNumber : duplicate.getDuplicateNumber(answerNumbers, player)) {
            if (answerNumbers.indexOf(overlapNumber) == player.indexOf(overlapNumber)) {
                strike += 1;
            }
        }
        return strike;
    }

    public int ball(List<Integer> answerNumbers, List<Integer> player) {
        int ball = 0;
        for (int overlapNumber : duplicate.getDuplicateNumber(answerNumbers, player)) {
            if (answerNumbers.indexOf(overlapNumber) != player.indexOf(overlapNumber)) {
                ball += 1;
            }
        }
        return ball;
    }
}
