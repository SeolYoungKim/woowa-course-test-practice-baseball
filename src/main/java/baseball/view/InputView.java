package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    // 서로 다른 3자리의 숫자를 입력 받는다.
    public String threeNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    // 게임이 끝난 경우, 재시작/종료를 구분하는 1, 2중 하나의 숫자를 입력 받는다.
    public String restartOrQuit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
