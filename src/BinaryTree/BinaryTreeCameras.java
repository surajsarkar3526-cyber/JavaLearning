package BinaryTree;

public class BinaryTreeCameras {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        BinaryTreeCameras solution = new BinaryTreeCameras();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        System.out.println(solution.minCameraCover(root));
    }
    static int camera = 0;
    private int minCameraCover(TreeNode root) {
        if(dfs(root) == 2){
            camera++;
        }
        return camera;
    }
    private int dfs(TreeNode node) {
        if(node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(left == 2 || right == 2){
            camera++;
            return 1;
        }
        if(left == 1 || right == 1){
            return 0;
        }
        return 2;
    }
}
