package baseball.service;

import static baseball.domain.Numbers.NUMBER_COUNT;
import static baseball.domain.Numbers.NUMBER_MAX_INCLUSIVE;
import static baseball.domain.Numbers.NUMBER_MIN_INCLUSIVE;

import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumbersGenerator {

    public Numbers generate() {
        List<Integer> numbers = pickUniqueNumbersInRange();
        return new Numbers(numbers);
    }

    private List<Integer> pickUniqueNumbersInRange() {
        final Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < NUMBER_COUNT) {
            numbers.add(Randoms.pickNumberInRange(NUMBER_MIN_INCLUSIVE, NUMBER_MAX_INCLUSIVE));
        }

        return new ArrayList<>(numbers);
    }
}
