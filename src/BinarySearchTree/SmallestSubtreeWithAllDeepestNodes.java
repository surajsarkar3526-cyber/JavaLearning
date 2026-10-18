package BinarySearchTree;

public class SmallestSubtreeWithAllDeepestNodes {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    static class Result{
        int depth;
        TreeNode node;
        Result(int depth, TreeNode node){
            this.depth = depth;
            this.node = node;
        }
    }
    public static void main(String[] args) {
        SmallestSubtreeWithAllDeepestNodes solution = new SmallestSubtreeWithAllDeepestNodes();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode answer = solution.subtreeWithAllDeepest(root);
        System.out.println(answer.val);
    }

    private TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    private Result dfs(TreeNode root) {
        if(root == null){
            return new Result(0,null);
        }
        Result left = dfs(root.left);
        Result right = dfs(root.right);
        if(left.depth > right.depth){
            return new Result(left.depth+1,left.node);
        }
        if(right.depth > left.depth){
            return new Result(right.depth+1, right.node);
        }
        return new Result(left.depth+1, root);
    }
}
