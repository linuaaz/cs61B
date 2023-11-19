package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class DequeTest {
    @Test
    public void equalLLDAndAD() {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        LinkedListDeque<Integer> lld = new LinkedListDeque<>();
        lld.addLast(1);
        lld.addLast(2);
        lld.addLast(3);
        assertTrue(ad.equals(lld));
        assertTrue(lld.equals(ad));
    }
}
