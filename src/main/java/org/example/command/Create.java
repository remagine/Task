package org.example.command;

import org.example.tag.Tag;

import java.util.PriorityQueue;

public class Create implements Command {
    private final PriorityQueue<Tag> availableTags;

    public Create(PriorityQueue<Tag> availableTags) {
        this.availableTags = availableTags;
    }

    @Override
    public CommandResult execute() {
        // 생성은 어떤걸 의미하지?
        // 1-9까지 태그들 중 최소값을 뽑는다
        // 트리셋 보다 우선순위큐가 유리하다
        // 삽입과 삭제만 이뤄지지, 정렬된 상태를 유지해야하거나 , 조회하지 않기 때문이다
        // 그럼 이제 자료를 어디에 준비하지??
        // Create Class에 둘까? 그건 좀 아닌거같다
        // Tag? 그것도 아닌데
        // 가용태그목록은 출력에 쓰고, 처리에도 쓴다.
        // 그러니깐 사실 공용자원 인프라에 가깝다.
        // 그러니깐 Main에 선언하고 사용하는 게 좋다
        Tag minTag = availableTags.poll();
        if (minTag == null) {
            return CommandResult.fail(Tag.getEmpty());
        }

        return CommandResult.success(Tag.getEmpty());
    }
}
