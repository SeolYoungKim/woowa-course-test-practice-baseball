package baseball.view;

import baseball.constants.SystemMessage;

public class PlayerOutput {
    public void printNotSing(String notSing) {
        System.out.println(notSing);
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public void printStartGame() {
        System.out.println(SystemMessage.START_GAME);
    }

    public void printNumberInput() {
        System.out.print(SystemMessage.NUMBER_INPUT);
    }

    public void printAnswer() {
        System.out.println(SystemMessage.ANSWER_CORRECT);
    }

    public void printRestartGame() {
        System.out.println(SystemMessage.RESTART_GAME);
    }

}