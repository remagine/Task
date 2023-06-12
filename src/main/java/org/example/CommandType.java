import java.util.Arrays;

public enum CommandType {
    CREATE("create"), EXECUTE("execute");

    private final String value;

    CommandType(String value) {
        this.value = value;
    }

    public static CommandType from(String input) {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> commandType.value.equalsIgnoreCase(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 commandName : " + input));
    }
}
