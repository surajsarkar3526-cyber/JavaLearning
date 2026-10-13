package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0])
        );
        int n = buildings.length;
        int i = 0;
        int previousHeight = 0;
        while (i < n || !maxHeap.isEmpty()) {
            int x;
            if (maxHeap.isEmpty()
                    || (i < n && buildings[i][0] <= maxHeap.peek()[1])) {
                x = buildings[i][0];
                while (i < n && buildings[i][0] == x) {
                    maxHeap.offer(new int[]{
                            buildings[i][2],
                            buildings[i][1]
                    });
                    i++;
                }
            }
            else {
                x = maxHeap.peek()[1];
            }
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] <= x) {
                maxHeap.poll();
            }
            int currentHeight = maxHeap.isEmpty()
                    ? 0
                    : maxHeap.peek()[0];
            if (currentHeight != previousHeight) {
                result.add(Arrays.asList(x, currentHeight));
                previousHeight = currentHeight;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TheSkylineProblem solution = new TheSkylineProblem();
        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };
        List<List<Integer>> result = solution.getSkyline(buildings);
        System.out.println(result);
    }
}
