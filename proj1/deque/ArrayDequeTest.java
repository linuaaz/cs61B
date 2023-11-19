package deque;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addIsEmptySizeTest() {
        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized ADeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();
    }

    @Test
    public void addRemoveTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    public void removeEmptyTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }
    
    @Test
    public void multipleParamTest() {
        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        ArrayDeque<Double> lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }
    
    @Test
    public void emptyNullReturnTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());
    }
    
    @Test
    public void bigADequeTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    public void smallADequeTest() {
        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 16; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 8; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 15; i > 8; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }
    }

    @Test
    public void addRemoveLastTest() {
        ArrayDeque<Integer> l = new ArrayDeque<>();
        l.addLast(1);
        int last = l.removeLast();

        assertEquals(1, last);
        assertEquals(null, l.removeLast());

        l.addLast(2);
        l.addLast(3);
        l.addLast(4);

        assertEquals(3, l.size());
    }

    @Test
    public void sizeTest() {
        ArrayDeque<Integer> l = new ArrayDeque<>();
        l.addLast(1);
        assertEquals(1, l.size());
        assertFalse(l.isEmpty());
        l.removeFirst();
        assertEquals(0,l.size());
        assertTrue(l.isEmpty());
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> l = new ArrayDeque<>();
        l.addFirst(1);
        l.addLast(2);
        l.addFirst(3);

        int a = l.get(0);
        int b = l.get(1);
        int c = l.get(2);

        assertEquals(3, a);
        assertEquals(1, b);
        assertEquals(2, c);
        assertEquals(null, l.get(100));
    }

    @Test
    public void iteratorTest() {
        ArrayDeque<Integer> l = new ArrayDeque<>();
        Iterator<Integer> iterator = l.iterator();
        assertFalse(iterator.hasNext());

        l.addLast(1);
        l.addLast(2);
        l.addLast(3);

        Integer expected = 0;
        for (Integer i : l) {
            expected++;
            assertEquals(expected, i);
        }

        Integer expected2 = 0;
        assertTrue(iterator.hasNext());
        while (iterator.hasNext()) {
            expected2++;
            assertEquals(expected2, iterator.next());
        }
    }
    
    @Test
    public void equalTest() {
        ArrayDeque<Integer> l1 = new ArrayDeque<>();
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);

        ArrayDeque<Integer> l2 = new ArrayDeque<>();
        l2.addLast(1);
        l2.addLast(2);
        l2.addLast(3);

        ArrayDeque<String> l3 = new ArrayDeque<>();
        l3.addLast("1");
        l3.addLast("2");
        l3.addLast("3");

        ArrayDeque<Integer> l4 = new ArrayDeque<>();
        l4.addLast(2);
        l4.addLast(3);
        l4.addLast(4);

        assertTrue(l1.equals(l1));
        assertTrue(l1.equals(l2));
        assertTrue(l2.equals(l1));
        assertFalse(l2.equals(l3));
        assertFalse(l1.equals(l3));
        assertFalse(l1.equals(l4));
        assertFalse(l2.equals(l4));
    }
}
