package org.example;

import java.util.Objects;

public class Tag implements Comparable<Tag>{
    private final int id;

    public Tag(int id) {
        if(id < 0 || id > 9){
            throw new RuntimeException("유효하지 않은 값으로 Tag를 생성시도하였습니다.");
        }
        this.id = id;
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
