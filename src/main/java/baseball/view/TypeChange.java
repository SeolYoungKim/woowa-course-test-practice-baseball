package baseball.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TypeChange {

    private char[] splitNumberArrangement(String number) {
        return number.toCharArray();
    }

    public List<Integer> splitNumberList(String number) {
        List<Integer> numberSplitList = new ArrayList<>();

        for (char oneNumber : splitNumberArrangement(number)) {
            numberSplitList.add(oneNumber - '0');
        }
        return numberSplitList;
    }

    public Set<Integer> splitNumberSet(String number) {
        return new HashSet<>(splitNumberList(number));
    }
}