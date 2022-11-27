package baseball.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Duplicate {

    public List<Integer> getDuplicateNumber(List<Integer> computer, List<Integer> player) {
        return computer.stream()
                .filter(number -> player.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList());
    }
}
