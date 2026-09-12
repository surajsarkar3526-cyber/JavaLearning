package Heap;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {

        int[] arr = {10, 5, 4, 3, 48, 6, 2, 33, 53, 10};
        int k = 4;

        int ans = kthSmallest(arr, k);
        System.out.println("Kth Smallest Element = " + ans);
    }

    private static int kthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int ele : arr){
            minHeap.offer(ele);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        Integer ans = minHeap.peek();
        if (ans == null) {
            throw new IllegalStateException("Heap is empty");
        }

        return ans;
    }
}
