package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) {

        int[] arr = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        int k = 4;

        int ans = kthSmallest(arr, k);
        System.out.println("Kth Smallest Element = " + ans);
    }

    private static int kthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : arr){
            maxHeap.offer(ele);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        Integer ans = maxHeap.peek();
        if (ans == null) {
            throw new IllegalStateException("Heap is empty");
        }

        return ans;
    }
}
