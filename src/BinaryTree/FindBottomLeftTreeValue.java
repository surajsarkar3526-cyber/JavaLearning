package BinaryTree;

public class FindBottomLeftTreeValue {
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        System.out.println(findBottomLeftValue(root));
    }
    static int answer = 0;
    static int maxDepth = -1;
    private static int findBottomLeftValue(TreeNode root) {
        answer = 0;
        maxDepth = -1;
        dfs(root,0);
        return answer;
    }

    private static void dfs(TreeNode root, int depth) {
        if(root == null){
            return;
        }
        if(depth > maxDepth){
            maxDepth = depth;
            answer = root.val;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}
