package Heap;

import java.util.PriorityQueue;

public class MinHeapExample {

    public static void main(String[] args) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(20);
        minHeap.offer(15);
        minHeap.offer(30);
        minHeap.offer(5);
        minHeap.offer(10);

        System.out.println("Min Heap: " + minHeap);

        System.out.println("Top Element: " + minHeap.peek());

        System.out.println("Removed: " + minHeap.poll());

        System.out.println("After Deletion: " + minHeap);

        System.out.print("Elements: ");

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
    }
}