package baseball.view;

import baseball.view.TypeChange;

import java.util.*;

public class Verification {

    TypeChange typeChange = new TypeChange();


    public void verifyThreeNumber(String number) {
        if (!(number.length() == 3)) {
            throw new IllegalArgumentException("");
        }
    }

    public void verify1Between9(String number) {
        for (int numbers : typeChange.splitNumberList(number)) {
            if (!(1 <= numbers && numbers <= 9)) {
                throw new IllegalArgumentException("");
            }
        }
    }

    public void verifyDuplicateNumber(String number) {
        if (!(typeChange.splitNumberList(number).size() == typeChange.splitNumberSet(number).size())) {
            throw new IllegalArgumentException("");
        }
    }

    public void verify1Or2(String number) {
        if (!(Objects.equals(number, "1") || Objects.equals(number, "2"))) {
            throw new IllegalArgumentException("");
        }
    }


}