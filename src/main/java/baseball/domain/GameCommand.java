package baseball.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum GameCommand {

    INIT("0"),
    RESTART("1"),
    QUIT("2"),
    ;

    private static final Map<String, GameCommand> GAME_COMMANDS = Arrays.stream(values())
            .filter(gameCommand -> !gameCommand.command.equals("0"))
            .collect(Collectors.toUnmodifiableMap(
                    gameCommand -> gameCommand.command,
                    Function.identity()));

    private final String command;

    public static GameCommand of(String inputValue) {
        if (!GAME_COMMANDS.containsKey(inputValue)) {
            throw new IllegalArgumentException("1 또는 2만 입력해 주세요. 재시작: 1 | 종료: 2");
        }

        return GAME_COMMANDS.get(inputValue);
    }

    GameCommand(String command) {
        this.command = command;
    }

    public boolean is(GameCommand gameCommand) {
        return this == gameCommand;
    }
}
