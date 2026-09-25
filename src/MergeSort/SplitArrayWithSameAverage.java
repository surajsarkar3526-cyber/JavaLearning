package MergeSort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class SplitArrayWithSameAverage {
    public static boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int mid = n / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, n);
        List<Set<Integer>> leftSums = new ArrayList<>();
        for (int i = 0; i <= left.length; i++) {
            leftSums.add(new HashSet<>());
        }
        generateSums(left, 0, 0, 0, leftSums);
        if(checkRight(right, 0, 0, 0, leftSums, totalSum, n)) {
            return true;
        }
        return false;
    }
    private static void generateSums(
            int[] nums,
            int index,
            int count,
            int sum,
            List<Set<Integer>> sums
    ) {
        if (index == nums.length) {
            sums.get(count).add(sum);
            return;
        }
        generateSums(nums, index + 1, count, sum, sums);
        generateSums(
                nums,
                index + 1,
                count + 1,
                sum + nums[index],
                sums
        );
    }
    private static boolean checkRight(
            int[] nums,
            int index,
            int count,
            int sum,
            List<Set<Integer>> leftSums,
            int totalSum,
            int n
    ) {
        if (index == nums.length) {
            for (int leftCount = 0; leftCount < leftSums.size(); leftCount++) {
                int totalCount = leftCount + count;
                if (totalCount == 0 || totalCount == n) {
                    continue;
                }
                int requiredSumNumerator = totalCount * totalSum - sum * n;
                if (requiredSumNumerator % n != 0) {
                    continue;
                }
                int requiredLeftSum = requiredSumNumerator / n;
                if (leftSums.get(leftCount).contains(requiredLeftSum)) {
                    return true;
                }
            }
            return false;
        }
        if (checkRight(
                nums,
                index + 1,
                count,
                sum,
                leftSums,
                totalSum,
                n
        )) {
            return true;
        }
        if (checkRight( nums,
                index + 1,
                count + 1,
                sum + nums[index],
                leftSums,
                totalSum,
                n
        )) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(splitArraySameAverage(nums));
    }
}
