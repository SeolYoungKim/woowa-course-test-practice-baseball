package baseball.domain;

import java.util.List;

public class Strike {

    public int findCountStrike(Baseball baseball) {
        List<Integer> player = baseball.playerNumbers();
        List<Integer> computer = baseball.computerNumbers();

        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (player.get(i).equals(computer.get(i))) {
                strike++;
            }
        }
        return strike;
    }
}
