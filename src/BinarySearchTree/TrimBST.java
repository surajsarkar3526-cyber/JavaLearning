package BinarySearchTree;

public class TrimBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        TreeNode result = trimBST(root, 1, 3);
        System.out.print("Trimmed BST (Inorder): ");
        inorder(result);
    }

    private static void inorder(TreeNode result) {
        if(result == null){
            return;
        }
        inorder(result.left);
        System.out.println(result.val+" ");
        inorder(result.right);
    }

    private static TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        if(root.val < low){
            return trimBST(root.right, low, high);
        }
        if(root.val > high){
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
