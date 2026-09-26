package MergeSort;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestSubsequenceSum {
    public static void main(String[] args) {
        int[] nums1 = {5, -7, 3, 5};
        int goal1 = 6;
        System.out.println(minAbsDifference(nums1, goal1));
        int[] nums2 = {7, -9, 15, -2};
        int goal2 = -5;
        System.out.println(minAbsDifference(nums2, goal2));
        int[] nums3 = {1, 2, 3};
        int goal3 = -7;
        System.out.println(minAbsDifference(nums3, goal3));
    }
    private static int minAbsDifference(int[] nums, int goal){
        int n = nums.length;
        int mid = n/2;
        int[] left = Arrays.copyOfRange(nums,0,mid);
        int[] right = Arrays.copyOfRange(nums,mid,n);
        List<Integer> leftSums = new ArrayList<>();
        List<Integer> rightSums = new ArrayList<>();
        generateSums(left, 0, 0, leftSums);
        generateSums(right, 0, 0, rightSums);
        Collections.sort(rightSums);
        int answer = Integer.MAX_VALUE;
        for(int num : leftSums){
            int required = goal - num;
            int index = Collections.binarySearch(rightSums,required);
            if(index >= 0){
                return 0;
            }
            int insertionPoint = -(index) - 1;
            if(insertionPoint < rightSums.size()){
                int rightSum = rightSums.get(insertionPoint);
                int total = num + rightSum;
                answer = Math.min(answer, Math.abs(total-goal));
            }
            if(insertionPoint > 0){
                int rightSum = rightSums.get(insertionPoint - 1);
                int total = num + rightSum;
                answer = Math.min(answer, Math.abs(total-goal));
            }
        }
        return answer;
    }
    private static void generateSums(int[] left, int index, int sum, List<Integer> sums) {
        if(index == left.length){
            sums.add(sum);
            return;
        }
        generateSums(left, index+1, sum, sums);
        generateSums(left, index+1, sum+left[index], sums);
    }
}
