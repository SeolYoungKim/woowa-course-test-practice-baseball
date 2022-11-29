package baseball.domain;

import java.util.List;

public class IdenticalNumberCount {
    public int findPlayersAndComputer(Baseball baseball) {
        List<Integer> player = baseball.playerNumbers();
        List<Integer> computer = baseball.computerNumbers();

        int correct = 0;
        for (int computerNumber : computer) {
            if (player.contains(computerNumber)) {
                correct++;
            }
        }
        return correct;
    }
}
