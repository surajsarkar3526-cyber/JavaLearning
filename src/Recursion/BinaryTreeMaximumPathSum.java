package Recursion;

public class BinaryTreeMaximumPathSum {
    static int maxSum = Integer.MIN_VALUE;
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }

    private static int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftGain = Math.max(0,dfs(root.left));
        int rightGain = Math.max(0, dfs(root.right));
        int currentPath = leftGain+root.val+rightGain;
        maxSum = Math.max(maxSum,currentPath);
        return root.val + Math.max(leftGain,rightGain);
    }
}
