package BinaryTree;

public class CountCompleteTreeNodes {
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        int result = countNodes(root);
        System.out.println("Total Nodes = " + result);
    }

    private static int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if(leftHeight == rightHeight){
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int getRightHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        int height = 0;
        while(root != null){
            root = root.right;
            height++;
        }
        return height;
    }

    private static int getLeftHeight(TreeNode root) {
        if(root == null){
            return 0;
        }
        int height = 0;
        while(root != null){
            root = root.left;
            height++;
        }
        return height;
    }
}
