package org.example;

public class CommandFactory {
    private static final CommandFactory commandFactory = new CommandFactory();

    public static CommandFactory getInstance() {
        return commandFactory;
    }

    public Command get(CommandType commandType){
        Command command;
        switch (commandType){
            case CREATE:
                command = new Create();
                break;
            case EXECUTE:
                command = new Execute();
                break;
            default:
                throw new RuntimeException();
        }
        return command;
    }
}
