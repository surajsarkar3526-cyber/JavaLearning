package BinarySearchTree;

public class ConstructBSTFromPreorder {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = bstFromPreorder(preorder);
        System.out.println("Constructed BST:");
        System.out.println("Inorder:");
        inorder(root);
        System.out.println();
        System.out.println("Preorder:");
        preorder(root);
    }
    private static int index = 0;
    private static TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return buildTre(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode buildTre(int[] preorder, int minValue, int maxValue) {
        if(index >= preorder.length){
            return null;
        }
        int value = preorder[index];
        if(value > maxValue || value < minValue){
            return null;
        }
        index++;
        TreeNode root = new TreeNode(value);
        root.left = buildTre(preorder,minValue,root.val);
        root.right = buildTre(preorder,root.val,maxValue);

        return root;
    }

    private static void preorder(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.println(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    private static void inorder(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val+" ");
        inorder(root.right);
    }
}
