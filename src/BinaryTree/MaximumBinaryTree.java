package BinaryTree;

public class MaximumBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = buildTree(nums, 0, nums.length - 1);
        System.out.println("Maximum Binary Tree created.");
    }

    private static TreeNode buildTree(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int maxIndex = left;
        for(int i=left+1; i<=right; i++){
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTree(nums, left, maxIndex - 1);
        root.right = buildTree(nums, maxIndex+1, right);

        return root;
    }
}
