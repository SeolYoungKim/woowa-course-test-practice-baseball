package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private final Verification verification;
    private final TypeChange typeChange;

    public InputView(Verification verification, TypeChange typeChange) {
        this.verification = verification;
        this.typeChange = typeChange;
    }

    private String readLine() {
        return Console.readLine();
    }

    public List<Integer> readPlayerNumber() {
        String number = readLine();
        verification.verifyThreeNumber(number);
        verification.verify1Between9(number);
        verification.verifyDuplicateNumber(number);
        return typeChange.splitNumberList(number);
    }

    public String readRetry() {
        String retry = readLine();
        verification.verify1Or2(retry);
        return retry;
    }
}
