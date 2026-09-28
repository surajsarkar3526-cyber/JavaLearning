package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElementsHeap {
    public static void main(String[] args) {
        FindKClosestElementsHeap obj = new FindKClosestElementsHeap();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        List<Integer> result = obj.findClosestElements(arr, k, x);
        System.out.println(result);
    }

    private List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->{
            int distanceA = Math.abs(a-x);

            int distanceB = Math.abs(b - x);
            if(distanceA != distanceB){
                return Integer.compare(distanceA,distanceB);
            }
            return Integer.compare(a,b);
        });
        for(int num : arr){
            minHeap.offer(num);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<k; i++){
            result.add(minHeap.poll());
        }
        Collections.sort(result);
        return result;
    }
}
