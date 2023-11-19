package tester;

import static org.junit.Assert.*;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {

    @Test
    public void addFirstTest() {
        final int size = 256;
        StudentArrayDeque<Integer> bd = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> ad = new ArrayDequeSolution<>();

        StringBuilder b = new StringBuilder();
        b.append("\n");

        for (int i = 0; i < size; i++) {
            double f = StdRandom.uniform(0, 4);

            if (f == 0) {
                bd.addLast(i);
                ad.addLast(i);
                b.append("addLast(").append(i).append(")\n");
            } else if (f == 1) {
                bd.addFirst(i);
                ad.addFirst(i);
                b.append("addFirst(").append(i).append(")\n");
            }

            if (bd.isEmpty()) {
                continue;
            }

            if (f == 2) {
                b.append("removeLast()\n");
                assertEquals(b.toString(), ad.removeLast(), bd.removeLast());
            } else if (f == 3) {
                b.append("removeFirst()\n");
                assertEquals(b.toString(),ad.removeFirst(), bd.removeFirst());
            }
        }

    }
}
