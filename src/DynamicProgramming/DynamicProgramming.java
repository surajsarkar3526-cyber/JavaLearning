package DynamicProgramming;

public class DynamicProgramming {
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
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root));
    }

    private static int rob(TreeNode root) {
        int[] result = solve(root);
        return Math.max(result[0], result[1]);
    }

    private static int[] solve(TreeNode root) {
        if(root == null){
            return new int[]{0,0};
        }
        int[] leftMax = solve(root.left);
        int[] rightMax = solve(root.right);
        int rob = root.val + leftMax[1] + rightMax[1];
        int notRob = Math.max(leftMax[1], leftMax[0]) + Math.max(rightMax[1], rightMax[0]);
        return new int[]{rob, notRob};
    }
}
