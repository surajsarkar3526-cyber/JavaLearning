package BinarySearchTree;

public class BinaryTreePruning {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        BinaryTreePruning solution = new BinaryTreePruning();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        root = solution.pruneTree(root);
        System.out.println("Tree pruning completed.");
    }

    private TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val==0 && root.left == null && root.right == null){
            return null;
        }
        return root;
    }
}
