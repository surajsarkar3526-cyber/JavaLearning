package Heap;

import java.util.Objects;
import java.util.PriorityQueue;

public class MinCostToConnectRopes {

    public static void main(String[] args) {

        int[] arr = {4, 3, 2, 6};

        int ans = minCost(arr);

        System.out.println("Minimum Cost = " + ans);
    }

    static int minCost(int[] arr) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        for(int ele : arr){
            minHeap.offer(ele);
        }
        int totalCoast = 0;
        while(minHeap.size() > 1){

            int first = Objects.requireNonNull(minHeap.poll());
            int second = Objects.requireNonNull(minHeap.poll());
            int coast = first + second;

            totalCoast += coast;
            minHeap.offer(coast);

        }
        return totalCoast;
    }
}
