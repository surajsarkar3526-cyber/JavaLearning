package BinarySearchTree;

public class InsertIntoBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int val = 5;
        root = insertIntoBST(root, val);
        System.out.print("Inorder: ");
        inorder(root);
    }

    private static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }
        else if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    private static void inorder(TreeNode result) {
        if(result == null){
            return;
        }
        inorder(result.left);
        System.out.println(result.val+" ");
        inorder(result.right);
    }
}
