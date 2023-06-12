package org.example;

import java.util.Set;

public class Execute implements Command {
    private final Tag tag;
    public Execute(Tag tag, Set<Tag> executableTags) {
        if(tag == null){
            throw new IllegalArgumentException(); // checked 예외 , 처리가 강제된다.
            /*throw new RuntimeException();*/ // unchecked 예외, 예외처리가 강제되지 않는다.
            // 여기서 처리를 강제해야할까? 아니면 강제하지 않아도 될까?
            // 어떤 것이 더 좋을까?
            // R/E는 처리를 강제하지 않기에, 컴파일 에러가 없다. 그래서 에러가 났을때 catch가 없어 강제종료될 수도 있다
            // 그러므로 I/E가 더 좋아 보인다.
        }
        this.tag = tag;
    }

    @Override
    public CommandResult execute() {


        return null;
    }
}