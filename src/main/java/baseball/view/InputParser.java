package baseball.view;

import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    List<Integer> parseNumbers(String numbers) {
        return numbers.chars()
                .mapToObj(c -> c - '0')
                .collect(Collectors.toList());
    }
}
