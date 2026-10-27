package BinaryTree;

import java.util.Stack;

public class RecoverTreeFromPreorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        RecoverTreeFromPreorderTraversal solution = new RecoverTreeFromPreorderTraversal();

        TreeNode root = solution.recoverFromPreorder("1-2--3--4-5--6--7");

        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left.val);
        System.out.println(root.left.right.val);
    }

    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (i < traversal.length()) {
            int depth = 0;
            while (i < traversal.length()
                    && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }
            int value = 0;
            while (i < traversal.length()
                    && Character.isDigit(traversal.charAt(i))) {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(value);
            while (stack.size() > depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                }
                else {
                    parent.right = node;
                }
            }
            stack.push(node);
        }
        return stack.firstElement();
    }
}
