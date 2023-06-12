import java.util.PriorityQueue;
import org.example.Tag;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TagTest {

    @Test
    public void tagComparison(){
        // given
        Tag minTag = new Tag(4);
        Tag maxTag = new Tag(9);
        PriorityQueue<Tag> queue = new PriorityQueue<>();
        // when
        queue.add(maxTag);
        queue.add(minTag);
        // then
        Tag firstTag = queue.poll();
        Tag lastTag = queue.poll();

        Assertions.assertEquals(minTag, firstTag);
        Assertions.assertEquals(maxTag, lastTag);
    }

}
