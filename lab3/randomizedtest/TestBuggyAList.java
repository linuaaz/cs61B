package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> cl = new AListNoResizing<>();
        BuggyAList<Integer> bl = new BuggyAList<>();
        for (int i = 0; i < 3; i++) {
            cl.addLast(i + 4);
            bl.addLast(i + 4);
        }
        assertEquals(cl.size(), bl.size());
        for (int i = 0; i < 3; i++) {
            assertEquals(cl.getLast(), bl.getLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> cl = new AListNoResizing<>();
        BuggyAList<Integer> bl = new BuggyAList<>();
        int N = 50000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                cl.addLast(randVal);
                bl.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                System.out.println("cl size: " + cl.size());
                System.out.println("bl size: " + bl.size());
            } else if (operationNumber == 2) {
                if (cl.size() <= 0) {
                    continue;
                }
                Integer last = cl.getLast();
                System.out.println("cl getLast()" + " = " + last);
                Integer bLast = bl.getLast();
                System.out.println("bl getLast()" + " = " + bLast);
            } else if (operationNumber == 3) {
                if (cl.size() <= 0) {
                    continue;
                }
                Integer last = cl.removeLast();
                System.out.println("cl removeLast()" + " = " + last);
                Integer bLast = bl.removeLast();
                System.out.println("bl removeLast()" + " = " + bLast);
            }
        }
    }
}
