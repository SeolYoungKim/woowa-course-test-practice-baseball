package baseball.domain;

public class Referee {

    public String Judgment(int ball, int strike, int correct) {
        if (correct == 0) {
            return "낫싱";
        }

        if (ball > 0 && strike > 0) {
            return ball + "볼 " + strike + "스트라이크";
        }

        if (strike > 0 && ball == 0) {
            return strike + "스트라이크";
        }

        return ball + "볼";
    }
}
