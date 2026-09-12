package Heap;

import java.util.*;

public class KClosetElements {

    static class Pair {
        int value;
        int distance;

        Pair(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> {

            if (a.distance != b.distance) {
                return b.distance - a.distance;
            }
            return b.value - a.value;
        });

        for (int num : arr) {

            int distance = Math.abs(num - x);

            maxHeap.offer(new Pair(num, distance));

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> answer = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            answer.add(maxHeap.poll().value);
        }

        Collections.sort(answer);

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;

        List<Integer> result = findClosestElements(arr, k, x);

        System.out.println(result);
    }
}