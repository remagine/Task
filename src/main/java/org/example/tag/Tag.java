package org.example.tag;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tag implements Comparable<Tag>{
    private final int id;
    private static final int EMPTY_TAG = 0;

    public Tag(int id) {
        if(id < EMPTY_TAG || id > 9){
            throw new RuntimeException("유효하지 않은 값으로 Tag를 생성시도하였습니다.");
        }
        this.id = id;
    }

    public static Tag from(String input){
        return new Tag(Integer.parseInt(input));
    }

    // new Tag(0)은 데이터적인 관점. 맥락이 없으면 이해될 수 없는 코드
    // EMPTY_TAG라는 개념으로 접근할 수 있도록
    public static Tag getEmpty(){
        return new Tag(EMPTY_TAG);
    }

    public static PriorityQueue<Tag> initAvailableTags(){
        return IntStream.rangeClosed(1,9)
                .mapToObj(Tag::new)
                .collect(Collectors.toCollection(PriorityQueue::new));

    }

    public static Set<Tag> initExecutableTags() {
        return new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        return id == tag.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Tag o) {
        Objects.requireNonNull(o, "Comparison tag cannot be null.");
        return  this.id - o.id;
    }
}
