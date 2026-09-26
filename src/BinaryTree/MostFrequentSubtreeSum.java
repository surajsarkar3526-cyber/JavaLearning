package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class MostFrequentSubtreeSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static HashMap<Integer, Integer> frequency = new HashMap<>();
    static int maxFrequency = 0;
    static int subtreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSum = subtreeSum(node.left);
        int rightSum = subtreeSum(node.right);
        int sum = node.val + leftSum + rightSum;
        int count = frequency.getOrDefault(sum, 0) + 1;
        frequency.put(sum, count);
        maxFrequency = Math.max(maxFrequency, count);
        return sum;
    }

    static int[] findFrequentTreeSum(TreeNode root) {
        subtreeSum(root);
        ArrayList<Integer> result = new ArrayList<>();
        for (int sum : frequency.keySet()) {
            if (frequency.get(sum) == maxFrequency) {
                result.add(sum);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        int[] answer = findFrequentTreeSum(root);
        System.out.println(Arrays.toString(answer));
    }
}
