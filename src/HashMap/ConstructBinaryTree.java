package HashMap;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        private int preorderIndex = 0;
        private Map<Integer, Integer> inorderMap;

        public static void main(String[] args) {
            int[] preorder = {3, 9, 20, 15, 7};
            int[] inorder = {9, 3, 15, 20, 7};
            Solution solution = new Solution();
            TreeNode root = solution.buildTree(preorder, inorder);
            System.out.println("Tree constructed successfully.");
            System.out.print("Preorder: ");
            printPreorder(root);
            System.out.print("\nInorder: ");
            printInorder(root);
        }

        private TreeNode buildTree(int[] preorder, int[] inorder) {
            inorderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }
            return build(preorder, 0, inorder.length - 1);
        }

        private TreeNode build(int[] preorder, int left, int right) {
            if (left > right) {
                return null;
            }
            int rootValue = preorder[preorderIndex++];
            TreeNode root = new TreeNode(rootValue);
            int rootIndex = inorderMap.get(rootValue);
            root.left = build(preorder, left, rootIndex - 1);
            root.right = build(preorder, rootIndex + 1, right);
            return root;
        }

        private static void printPreorder(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.val + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }

        private static void printInorder(TreeNode root) {
            if (root == null) {
                return;
            }
            printPreorder(root.left);
            System.out.print(root.val + " ");
            printPreorder(root.right);
        }
    }
}