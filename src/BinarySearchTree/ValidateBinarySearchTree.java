package BinarySearchTree;

public class ValidateBinarySearchTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    static TreeNode prev = null;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

    private static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(prev != null && root.val <= prev.val){
            return false;
        }
        prev = root;

        if(!isValidBST(root.right)){
            return false;
        }
        return true;
    }
}
