package BinarySearchTree;

public class KthSmallestElementInBST {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 1;
        System.out.println(kthSmallest(root, k));
    }
    static int count;
    static int answer;
    private static int kthSmallest(TreeNode root, int k) {
        count = 0;
        answer = 0;
        inorder(root,k);
        return answer;
    }

    private static void inorder(TreeNode node, int k) {
        if(node == null){
            return;
        }
        inorder(node.left,k);
        count++;
        if(count == k){
            answer = node.val;
            return;
        }
        inorder(node.right,k);
    }
}
