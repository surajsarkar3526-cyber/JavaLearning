package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        List<List<Integer>> result = pathSum(root, targetSum);
        System.out.println(result);
    }

    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, result, targetSum);
        return result;
    }

    private static void dfs(TreeNode root, List<Integer> path, List<List<Integer>> result, int targetSum) {
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                result.add(new ArrayList<>(path));
            }
        }
        else{
            dfs(root.left, path, result, targetSum - root.val);
            dfs(root.right, path, result, targetSum - root.val);
        }
        path.remove(path.size()-1);
    }
}
