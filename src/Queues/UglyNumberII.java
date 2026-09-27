package Queues;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumberII {
    public static int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        pq.add(1L);
        set.add(1L);
        long current = 1;
        for (int i = 0; i < n; i++) {
            current = pq.poll();
            long num2 = current * 2;
            long num3 = current * 3;
            long num5 = current * 5;
            if (set.add(num2)) {
                pq.add(num2);
            }
            if (set.add(num3)) {
                pq.add(num3);
            }
            if (set.add(num5)) {
                pq.add(num5);
            }
        }
        return (int) current;
    }
    public static void main(String[] args) {
        int n = 10;
        int answer = nthUglyNumber(n);
        System.out.println("The " + n + "th ugly number is: " + answer);
    }
}
