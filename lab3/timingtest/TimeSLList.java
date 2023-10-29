package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        int[] N = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        AList<Integer> ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for (int i = 0; i < N.length; i++) {
            ns.addLast(N[i]);
            AList<Integer> a = buildAList(N[i]);
            Stopwatch sw = new Stopwatch();
            getLast(a, 10000);
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            opCounts.addLast(10000);
        }
        printTimingTable(ns, times, opCounts);
    }

    public static AList<Integer> buildAList(int length) {
        AList<Integer> a = new AList<>();
        for (int i = 0; i < length; i++) {
            a.addLast(0);
        }
        return a;
    }

    public static void getLast(AList<Integer> aList, int n) {
        for (int i = 0; i < n; i++) {
            aList.getLast();
        }
    }
}
