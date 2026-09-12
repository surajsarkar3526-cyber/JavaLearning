package Heap;

import java.util.PriorityQueue;

public class CustomComparator {

    public static void main(String[] args) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b, a)
        );

        maxHeap.offer(10);
        maxHeap.offer(40);
        maxHeap.offer(20);
        maxHeap.offer(30);
        maxHeap.offer(50);

        System.out.println("Max Heap Elements:");

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }
}