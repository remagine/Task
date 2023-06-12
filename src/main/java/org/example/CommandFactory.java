package org.example;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class CommandFactory {
    private static final CommandFactory commandFactory = new CommandFactory();

    public static CommandFactory getInstance() {
        return commandFactory;
    }


    PriorityQueue<Tag> availableTags = new PriorityQueue<>();
    {
        for(int i = 1; i < 10 ; i++){
            availableTags.add(new Tag(i));
        }
    }

    Set<Tag> executableTags = new HashSet<>();

    public Command get(CommandType commandType, Tag tag){
        Command command;
        switch (commandType){
            case CREATE:
                command = new Create(availableTags);
                break;
            case EXECUTE:
                command = new Execute(tag, executableTags);
                break;
            default:
                throw new RuntimeException();
        }
        return command;
    }
}
