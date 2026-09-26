package Recursion;

public class FlattenBinaryTreeToLinkedList {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            if (current.left != null) {
                System.out.println("Error: left is not null");
                break;
            }
            current = current.right;
        }
    }
}
