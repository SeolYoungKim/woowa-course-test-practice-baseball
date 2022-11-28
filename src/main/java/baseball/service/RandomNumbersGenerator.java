package baseball.service;

import static baseball.domain.Number.NUMBER_MAX_INCLUSIVE;
import static baseball.domain.Number.NUMBER_MIN_INCLUSIVE;
import static baseball.domain.Numbers.NUMBERS_SIZE;

import baseball.domain.Number;
import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomNumbersGenerator {

    public Numbers generate() {
        List<Number> numbers = pickUniqueNumbersInRange().stream()
                .map(Number::new).collect(Collectors.toList());

        return new Numbers(numbers);
    }

    private List<Integer> pickUniqueNumbersInRange() {
        final Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < NUMBERS_SIZE) {
            numbers.add(Randoms.pickNumberInRange(NUMBER_MIN_INCLUSIVE, NUMBER_MAX_INCLUSIVE));
        }

        return new ArrayList<>(numbers);
    }
}
