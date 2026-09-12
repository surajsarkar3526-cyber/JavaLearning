package Heap;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySortedArray {

    public static void main(String[] args) {

        int[] arr = {2, 3, 1, 4};
        int k = 2;

        sortNearlySorted(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortNearlySorted(int[] arr, int k) {

        int index = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<=k && i < arr.length; i++){
            minHeap.offer(arr[i]);
        }

        for(int i=k+1; i<arr.length; i++){
            Integer value = minHeap.poll();
            if (value != null) {
                arr[index++] = value;
            }

            minHeap.offer(arr[i]);
        }

        while(!minHeap.isEmpty()){
            arr[index++] = minHeap.poll();
        }
    }
}
