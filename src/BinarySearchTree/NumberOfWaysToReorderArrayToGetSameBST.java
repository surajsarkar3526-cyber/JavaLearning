package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToReorderArrayToGetSameBST {
    static final long MOD = 1000000007;
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static int numOfWays(int[] nums) {
        int n = nums.length;
        long[][] comb = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
        return (int)((solve(nums, comb) - 1 + MOD) % MOD);
    }
    private static long solve(int[] nums, long[][] comb) {
        if (nums.length <= 2) {
            return 1;
        }
        int root = nums[0];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < root) {
                left.add(nums[i]);
            }
            else {
                right.add(nums[i]);
            }
        }
        int[] leftArray = new int[left.size()];
        int[] rightArray = new int[right.size()];
        for (int i = 0; i < left.size(); i++) {
            leftArray[i] = left.get(i);
        }
        for (int i = 0; i < right.size(); i++) {
            rightArray[i] = right.get(i);
        }
        long leftWays = solve(leftArray, comb);
        long rightWays = solve(rightArray, comb);
        long interleavings = comb[left.size() + right.size()][left.size()];
        return (((interleavings * leftWays) % MOD) * rightWays) % MOD;
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        long answer = numOfWays(nums);
        System.out.println("Number of ways = " + answer);
    }
}
