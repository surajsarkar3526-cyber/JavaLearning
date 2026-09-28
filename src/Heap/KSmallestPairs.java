package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> answer = kSmallestPairs(nums1, nums2, k);
        System.out.println(answer);
    }

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(nums1[a[0]]+nums2[a[1]],
                nums1[b[0]] + nums2[b[1]])
        );
        for(int i=0; i<Math.min(nums1.length,k); i++){
            minHeap.offer(new int[]{i,0});
        }
        while(!minHeap.isEmpty() && result.size() < k){
            int[] current = minHeap.poll();
            int i = current[0];
            int j = current[1];
            result.add(Arrays.asList(nums1[i],nums2[j]));
            if(j + 1 < nums2.length){
                minHeap.offer(new int[]{i,j+1});
            }
        }
        return result;
    }
}
