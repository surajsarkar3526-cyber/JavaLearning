package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        MaximumWidthBinaryTree solution = new MaximumWidthBinaryTree();
        System.out.println(solution.widthOfBinaryTree(root));
    }
    private int maxWidth = 0;
    private List<Long> firstIndex = new ArrayList<>();
    private int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0L, 0);
        return maxWidth;
    }

    private void dfs(TreeNode node, long index, int level) {
        if (node == null) {
            return;
        }
        if (level == firstIndex.size()) {
            firstIndex.add(index);
        }
        long width = index - firstIndex.get(level) + 1;
        maxWidth = (int) Math.max(maxWidth, width);
        dfs(node.left, 2 * index, level + 1);
        dfs(node.right, 2 * index + 1, level + 1);
    }
}
