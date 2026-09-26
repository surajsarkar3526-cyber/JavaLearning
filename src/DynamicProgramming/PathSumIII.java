package DynamicProgramming;

public class PathSumIII {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    static int count;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        long targetSum = 8;
        count = 0;
        pathSum(root, targetSum);
        System.out.println("Number of paths = " + count);
    }

    private static void pathSum(TreeNode root, long targetSum) {
        if(root == null){
            return;
        }
        FindPaths(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
    }

    private static void FindPaths(TreeNode root, long targetSum, int currentSum) {
        if(root == null){
            return;
        }
        currentSum += root.val;
        if(currentSum == targetSum){
            count++;
        }
        FindPaths(root.left, targetSum, currentSum);
        FindPaths(root.right, targetSum, currentSum);
    }
}
