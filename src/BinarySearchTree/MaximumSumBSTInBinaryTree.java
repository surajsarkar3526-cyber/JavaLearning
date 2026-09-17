package BinarySearchTree;

public class MaximumSumBSTInBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    static int maxSum = 0;
    static class Info {
        boolean isBST;
        int sum;
        int min;
        int max;
        Info(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxSumBST(TreeNode root) {
        maxSum = 0;
        postorder(root);
        return maxSum;
    }
    static Info postorder(TreeNode root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info left = postorder(root.left);
        Info right = postorder(root.right);
        if (left.isBST && right.isBST && left.max < root.val && root.val < right.min) {
            int sum = left.sum + root.val + right.sum;
            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);
            maxSum = Math.max(maxSum, sum);
            return new Info(true, sum, min, max);
        }
        return new Info(false, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        int answer = maxSumBST(root);
        System.out.println("Maximum Sum BST = " + answer);
    }
}
