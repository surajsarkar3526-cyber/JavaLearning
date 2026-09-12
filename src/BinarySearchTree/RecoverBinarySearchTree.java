package BinarySearchTree;

public class RecoverBinarySearchTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){
            
        }
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static TreeNode first = null;
    static TreeNode second = null;
    static TreeNode previous = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        recoverTree(root);
        System.out.println("Recovered BST:");
        printInorder(root);
    }

    private static void printInorder(TreeNode root) {
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.println(root.val+" ");
        printInorder(root.right);
    }

    private static void recoverTree(TreeNode root) {

        Inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private static void Inorder(TreeNode root) {
        if(root == null){
            return;
        }
        Inorder(root.left);
        if(previous != null && previous.val >= root.val){
            if(first == null){
                first = previous;
            }
            second = root;
        }
        previous = root;
        Inorder(root.right);
    }
}
