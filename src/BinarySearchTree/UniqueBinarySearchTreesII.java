package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> trees = generateTrees(n);
        System.out.println("Total BSTs = " + trees.size());
        for(TreeNode root : trees){
            printTrees(root);
            System.out.println();
        }
    }

    private static void printTrees(TreeNode root) {
        if(root == null){
            System.out.println("null");
            return;
        }
        System.out.println(root.val+" ");
        printTrees(root.left);
        printTrees(root.right);
    }

    private static List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<>();
        }
        return builtTrees(1, n);
    }

    private static List<TreeNode> builtTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if(start > end){
            result.add(null);
            return result;
        }
        for(int rootValue = start; rootValue <= end; rootValue++){
            List<TreeNode> leftTrees = builtTrees(start, rootValue-1);
            List<TreeNode> rightTrees = builtTrees(rootValue+1, end);

            for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                    TreeNode root = new TreeNode(rootValue);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
