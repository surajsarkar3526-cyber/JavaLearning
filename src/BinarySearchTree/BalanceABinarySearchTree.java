package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
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
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        TreeNode balancedRoot = balanceBST(root);
        System.out.println("Balanced BST (Preorder):");
        preorder(balancedRoot);
    }

    private static void preorder(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.println(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    private static TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        return buildBalancedTree(list, 0, list.size()-1);
    }

    private static TreeNode buildBalancedTree(List<TreeNode> list, int low, int high) {
        if(low > high){
            return null;
        }
        int mid = low + (high - low)/2;
        TreeNode root = list.get(mid);
        root.left = buildBalancedTree(list,low,mid-1);
        root.right = buildBalancedTree(list,mid+1,high);
        return root;
    }

    private static void inorder(TreeNode root, List<TreeNode>list) {
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}
