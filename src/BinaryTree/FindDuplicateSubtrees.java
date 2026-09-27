package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    static Map<String, Integer> subtreeId;
    static Map<Integer, Integer> frequency;
    static List<TreeNode> result;
    static int nextId = 1;
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subtreeId = new HashMap<>();
        frequency = new HashMap<>();
        result = new ArrayList<>();
        dfs(root);
        return result;
    }
    static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftId = dfs(root.left);
        int rightId = dfs(root.right);
        String key = root.val + "," + leftId + "," + rightId;
        if (!subtreeId.containsKey(key)) {
            subtreeId.put(key, nextId++);
        }
        int id = subtreeId.get(key);
        int count = frequency.getOrDefault(id, 0) + 1;
        frequency.put(id, count);
        if (count == 2) {
            result.add(root);
        }
        return id;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        List<TreeNode> answer = findDuplicateSubtrees(root);
        for (TreeNode node : answer) {
            System.out.println("Duplicate subtree root: " + node.val);
        }
    }
}
