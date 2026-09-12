package Heap;
import java.util.Arrays;
import java.util.PriorityQueue;

class Nodes implements Comparable<Nodes>{
    int value;
    int row;
    int col;

    Nodes(int value, int row, int col){
        this.value = value;
        this.row = row;
        this.col = col;
    }

    public int compareTo(Nodes other){
        return this.value - other.value;
    }
}
public class SmallestRangeInKLists {

    public static void main(String[] args) {

        int[][] mat = {
                {4, 7, 9, 12, 15},
                {0, 8, 10, 14, 20},
                {6, 12, 16, 30, 50}
        };

        System.out.println(Arrays.toString(smallestRange(mat)));
    }

    static int[] smallestRange(int[][] mat) {

        int n = mat.length;
        int k = mat[0].length;
        PriorityQueue<Nodes> pq = new PriorityQueue<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            pq.offer(new Nodes(mat[i][0], i, 0));
            max = Math.max(max, mat[i][0]);
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        while (true) {

            Nodes current = pq.poll();
            if (current == null) {
                break;
            }
            int min = current.value;

            if ((max - min < end - start) ||
                    (max - min == end - start && min < start)) {
                start = min;
                end = max;
            }

            if (current.col + 1 == k) {
                break;
            }

            int nextValue = mat[current.row][current.col + 1];

            pq.offer(new Nodes(nextValue, current.row, current.col + 1));

            max = Math.max(max, nextValue);
        }

        return new int[]{start, end};
    }
}
