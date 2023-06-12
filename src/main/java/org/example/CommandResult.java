package org.example;

/**
 * dto
 * isSuccess : 실패 여부
 * tag : 실행 태그
 */
// 어떤 커맨드가 실패했는지는 가질 필요가 없는가?
public class CommandResult {
    private final boolean isSuccess;
    private final Tag tag;

    public CommandResult(boolean isSuccess, Tag tag) {
        if(tag == null){
            throw new RuntimeException("CommandResult :: Tag is null");
        }
        this.isSuccess = isSuccess;
        this.tag = tag;
    }
    // true , false는 데이터 적인 관점 행위적 관점 접근이 좋다
    // true, false가 아니라 String이 규칙이 될 수 도 있다.
    // 실패라는 개념 자체가 중요하다. 이것을 자꾸 외부에 노출하면 안된다
    // 단순 dto이기 때문에 getter가 필요
    public CommandResult success(Tag tag){
        return new CommandResult(true, tag);
    }

    public CommandResult fail(Tag tag){
        return new CommandResult(false, tag);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public Tag getTag() {
        return tag;
    }
}
