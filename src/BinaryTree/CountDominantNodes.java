package BinaryTree;

public class CountDominantNodes {
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(1);
        int answer = countDominantNodes(root);
        System.out.println("Number of dominant nodes: " + answer);
    }

    private static int countDominantNodes(TreeNode root) {
        count = 0;
        dfs(root);

        return count;
    }

    private static int dfs(TreeNode root) {
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        int subtreeMax = Math.max(root.val, Math.max(leftMax, rightMax));
        if(root.val == subtreeMax){
            count++;
        }
        return subtreeMax;
    }
}
