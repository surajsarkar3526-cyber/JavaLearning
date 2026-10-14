package BinaryTree;

public class ConstructStringFromBinaryTree {
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
        ConstructStringFromBinaryTree solution = new ConstructStringFromBinaryTree();
        System.out.println(solution.tree2str(root));
    }

    private String tree2str(TreeNode root) {
        if(root == null){
            return "";
        }
        String result = String.valueOf(root.val);
        if (root.left != null) {
            result += "(" + tree2str(root.left) + ")";
        }
        else if (root.right != null) {
            result += "()";
        }
        if (root.right != null) {
            result += "(" + tree2str(root.right) + ")";
        }
        return result;
    }
}
