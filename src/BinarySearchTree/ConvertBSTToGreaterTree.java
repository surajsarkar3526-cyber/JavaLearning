package BinarySearchTree;

public class ConvertBSTToGreaterTree {
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
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        convertBST(root);
        System.out.println("Greater Tree:");
        printInorder(root);
    }

    private static void printInorder(TreeNode root) {
        if(root==null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.val+" ");
        printInorder(root.right);
    }
    private static int sum = 0;
    private static void convertBST(TreeNode root) {
        if(root == null){
            return;
        }
        convertBST(root.right);
        sum = sum + root.val;
        root.val = sum;
        convertBST(root.left);
    }
}
