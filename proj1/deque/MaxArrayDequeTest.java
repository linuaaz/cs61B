package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {

    public static Comparator<Integer> getIntegerComparator() {
        return new integerComparator();
    }

    private static class integerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static Comparator<Integer> getIntegerDescComparator() {
        return new integerDescComparator();
    }

    private static class integerDescComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }


    public static Comparator<String> getStringComparator() {
        return new stringComparator();
    }

    private static class stringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    public static Comparator<String> getStringLengthComparator() {
        return new stringComparator();
    }

    private static class stringLengthComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    @Test
    public void initTest() {
        MaxArrayDeque<String> lld1 = new MaxArrayDeque<String>(getStringComparator());
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
    public void maxStringTest() {
        MaxArrayDeque<String> lld1 = new MaxArrayDeque<String>(getStringComparator());
        lld1.addFirst("front");
        lld1.addLast("middle");
        lld1.addLast("back");
        String max =  lld1.max();
        assertEquals("middle", max);
    }

    @Test
    public void maxStringLengyhTest() {
        MaxArrayDeque<String> lld1 = new MaxArrayDeque<String>(getStringLengthComparator());
        lld1.addFirst("good day");
        lld1.addLast("good day");
        String max =  lld1.max();
        assertEquals("good day", max);
        lld1.addLast("good day!");
        max =  lld1.max();
        assertEquals("good day!", max);
    }

    @Test
    public void maxIntegerTest() {
        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>(getIntegerComparator());
        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);
        lld1.addLast(4);
        Integer max =  lld1.max(getIntegerDescComparator());
        Integer max2 = lld1.max();
        Integer expect = 1;
        Integer expect2 = 4;
        assertNotNull(max);
        assertNotNull(max2);
        assertEquals(expect, max);
        assertEquals(expect2, max2);
    }
}
