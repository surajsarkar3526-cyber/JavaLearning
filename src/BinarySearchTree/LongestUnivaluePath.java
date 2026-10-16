package BinarySearchTree;

public class LongestUnivaluePath {
    static int maxPath;
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(longestUnivaluePath(root));
    }

    private static int longestUnivaluePath(TreeNode root) {
        maxPath = 0;
        dfs(root);
        return maxPath;
    }
    private static int dfs(TreeNode node) {
        if(node == null){
            return 0;
        }
        int leftPath = 0;
        int rightPath = 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(node.left != null && node.left.val == node.val){
            leftPath = left + 1;
        }
        if(node.right != null && node.right.val == node.val){
            rightPath = right + 1;
        }
        maxPath = Math.max(maxPath, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
