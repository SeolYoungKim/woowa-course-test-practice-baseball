package baseball.domain;

import java.util.List;

/**
 * 12.09
 */
public class Baseball {
    private final List<Integer> player;
    private final List<Integer> computer;

    public Baseball(List<Integer> player, List<Integer> computer) {
        this.player = player;
        this.computer = computer;
    }

    public List<Integer> playerNumbers() {
        return player;
    }

    public List<Integer> computerNumbers() {
        return computer;
    }
}