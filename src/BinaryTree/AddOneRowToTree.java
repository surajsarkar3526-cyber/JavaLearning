package BinaryTree;

public class AddOneRowToTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        addRow(root, val, depth, 1);
        return root;
    }
    public static void addRow(TreeNode cur, int val, int depth, int currentDepth) {
        if (cur == null) {
            return;
        }
        if (currentDepth == depth - 1) {
            TreeNode oldLeft = cur.left;
            TreeNode oldRight = cur.right;
            cur.left = new TreeNode(val);
            cur.right = new TreeNode(val);
            cur.left.left = oldLeft;
            cur.right.right = oldRight;
            return;
        }
        addRow(cur.left, val, depth, currentDepth + 1);
        addRow(cur.right, val, depth, currentDepth + 1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        int val = 1;
        int depth = 2;
        root = addOneRow(root, val, depth);
    }
}
