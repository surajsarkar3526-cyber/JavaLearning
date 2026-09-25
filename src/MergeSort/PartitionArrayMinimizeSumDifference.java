package MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PartitionArrayMinimizeSumDifference {
    public static void main(String[] args) {
        int[] nums1 = {3, 9, 7, 3};
        System.out.println(minimumDifference(nums1));
        int[] nums2 = {-36, 36};
        System.out.println(minimumDifference(nums2));
        int[] nums3 = {2, -1, 0, 4, -2, -9};
        System.out.println(minimumDifference(nums3));
    }

    private static int minimumDifference(int[] nums) {
        int n = nums.length/2;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        int[] left = Arrays.copyOfRange(nums,0,n);
        int[] right = Arrays.copyOfRange(nums,n,2*n);
        List<Integer>[] leftSums = new ArrayList[n+1];
        List<Integer>[] rightSums = new ArrayList[n + 1];
        for(int i=0; i<=n; i++){
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }
        generateSums(left, 0, 0, 0, leftSums);
        generateSums(right, 0, 0, 0, rightSums);
        for(int i=0; i<=n; i++){
            Collections.sort(rightSums[i]);
        }
        int answer = Integer.MAX_VALUE;
        for (int k = 0; k <= n; k++) {
            List<Integer> leftList = leftSums[k];
            List<Integer> rightList = rightSums[n - k];
            for (int leftSum : leftList) {
                double target = totalSum / 2.0 - leftSum;
                int index = binarySearchClosest(rightList, target);
                if (index < rightList.size()) {
                    int selectedSum = leftSum + rightList.get(index);
                    int difference = Math.abs(totalSum - 2 * selectedSum);
                    answer = Math.min(answer, difference);
                }
                if (index > 0) {
                    int selectedSum = leftSum + rightList.get(index - 1);
                    int difference = Math.abs(totalSum - 2 * selectedSum);
                    answer = Math.min(answer, difference);
                }
            }
        }
        return answer;
    }

    private static int binarySearchClosest(List<Integer> rightList, double target) {
        int left = 0;
        int right = rightList.size();
        while(left<right){
            int mid = left+(right-left)/2;
            if(rightList.get(mid) < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    private static void generateSums(int[] left, int index, int count, int sum, List<Integer>[] sums) {
        if(index == left.length){
            sums[count].add(sum);
            return;
        }
        generateSums(left, index+1, count, sum, sums);
        generateSums(left, index+1, count+1,sum+left[index], sums);
    }
}
