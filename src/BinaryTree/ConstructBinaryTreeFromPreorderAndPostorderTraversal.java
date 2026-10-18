package BinaryTree;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndPostorderTraversal solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal();
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeNode root = solution.constructFromPrePost(preorder, postorder);

        System.out.print("Constructed Tree Preorder: ");
        solution.printPreorder(root);
    }

    private void printPreorder(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.print(root.val);
        printPreorder(root.left);
        printPreorder(root.right);
    }

    private TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buildTree(preorder, postorder, 0, 0, preorder.length);
    }
    private TreeNode buildTree(int[] preorder, int[] postorder, int preStart, int postStart, int size) {
        if(size == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if(size == 1){
            return root;
        }
        int leftRootValue = preorder[preStart+1];
        int leftRootIndex = postStart;
        while(postorder[leftRootIndex] != leftRootValue){
            leftRootIndex++;
        }
        int leftSize = leftRootIndex - postStart + 1;
        root.left = buildTree(preorder, postorder, preStart+1, postStart, leftSize);
        root.right = buildTree(preorder, postorder, preStart + leftSize + 1, postStart + leftSize, size - leftSize - 1);
        return root;
    }
}
