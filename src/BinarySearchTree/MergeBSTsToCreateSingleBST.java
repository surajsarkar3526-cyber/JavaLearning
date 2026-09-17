package BinarySearchTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class MergeBSTsToCreateSingleBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(1);
        TreeNode tree2 = new TreeNode(3);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(5);
        TreeNode tree3 = new TreeNode(5);
        tree3.left = new TreeNode(4);
        List<TreeNode> trees = new ArrayList<>();
        trees.add(tree1);
        trees.add(tree2);
        trees.add(tree3);
        TreeNode result = canMerge(trees);
        if (result == null) {
            System.out.println("null");
        }
        else {
            printTree(result);
        }
    }

    private static void printTree(TreeNode result) {
        if(result == null){
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(result);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            System.out.println(current.val+" ");
            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }
    }

    private static TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> rootMap = new HashMap<>();
        for(TreeNode tree : trees){
            rootMap.put(tree.val, tree);
        }
        Set<Integer> leafValues = new HashSet<>();
        for(TreeNode tree : trees){
            if(tree.left != null){
                leafValues.add(tree.left.val);
            }
            if(tree.right != null){
                leafValues.add(tree.right.val);
            }
        }
        TreeNode root = null;
        for(TreeNode tree : trees){
            if(!leafValues.contains(tree.val)){
                if(root != null){
                    return null;
                }
                root = tree;
            }
        }
        if(root == null){
            return null;
        }
        int mergedCount = 1+merge(root, rootMap, new HashSet<>());
        if(mergedCount != trees.size()){
            return null;
        }
        if(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)){
            return root;
        }
        else{
            return null;
        }
    }

    private static boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if(root == null){
            return true;
        }
        if(root.val <= minValue || root.val >= maxValue){
            return false;
        }

        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    private static int merge(TreeNode root, Map<Integer, TreeNode> rootMap, HashSet<Object> objects) {
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.left == null && root.right == null){
            TreeNode node = rootMap.get(root.val);
            if(node != null && node != root && !objects.contains(node.val)){
                root.left = node.left;
                root.right = node.right;
                objects.add(root.val);
                count += 1;
                count += merge(root.left, rootMap, objects);
                count += merge(root.right, rootMap, objects);
            }
            return count;
        }
        count += merge(root.left, rootMap, objects);
        count += merge(root.right, rootMap, objects);

        return count;
    }
}
