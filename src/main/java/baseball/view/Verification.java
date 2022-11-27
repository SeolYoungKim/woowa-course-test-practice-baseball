package baseball.view;

import java.util.*;

public class Verification {

    TypeChange typeChange = new TypeChange();


    public void verifyThreeNumber(String number) {
        if (!(number.length() == 3)) {
            throw new IllegalArgumentException("숫자 세개를 입력하세요");
        }
    }

    public void verify1Between9(String number) {
        for (int numbers : typeChange.splitNumberList(number)) {
            if (!(1 <= numbers && numbers <= 9)) {
                throw new IllegalArgumentException("1~9 사이의 숫자만 입력하세요");
            }
        }
    }

    public void verifyDuplicateNumber(String number) {
        if (!(typeChange.splitNumberList(number).size() == typeChange.splitNumberSet(number).size())) {
            throw new IllegalArgumentException("중복되지 않은 숫자를 입력하세요");
        }
    }

    public void verify1Or2(String number) {
        if (!(Objects.equals(number, "1") || Objects.equals(number, "2"))) {
            throw new IllegalArgumentException("1 또는 2만 입력해주세요");
        }
    }


}