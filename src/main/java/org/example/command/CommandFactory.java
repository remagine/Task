package org.example.command;

import org.example.tag.Tag;

import java.util.PriorityQueue;
import java.util.Set;

public class CommandFactory {
    private static final CommandFactory commandFactory = new CommandFactory();

    public static CommandFactory getInstance() {
        return commandFactory;
    }

    // 가용태그의 초기화는 언제 되는 게 좋을까?
    // 그리고 꼭 필요한 필드만 가져다 쓰는 팩토리를 만들고 싶은데 어떻게 하는게 좋을까?
    // 가용 태그는 누가 만들어야 되지??
    // 그리고 어디에 있어야 하지?

    public Command get(CommandType commandType, Tag tag, PriorityQueue<Tag> availableTags, Set<Tag> executableTags){
        Command command;
        switch (commandType){
            case CREATE:
                command = new Create(availableTags);
                break;
            case EXECUTE:
                command = new Execute(tag, executableTags, availableTags);
                break;
            default:
                throw new RuntimeException();
        }
        return command;
    }
}
