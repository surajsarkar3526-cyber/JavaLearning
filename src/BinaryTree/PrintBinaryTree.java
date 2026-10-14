package BinaryTree;
import java.util.ArrayList;
import java.util.List;
public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        int h = height(root);
        int rows = h + 1;
        int cols = (1 << (h + 1)) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            res.add(row);
        }
        dfs(root, res, 0, 0, cols - 1);
        return res;
    }
    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(
                height(root.left),
                height(root.right)
        );
    }
    private void dfs(TreeNode root,List<List<String>> res,int row,int left,int right) {
        if (root == null) {
            return;
        }
        int mid = (left + right) / 2;
        res.get(row).set(mid, String.valueOf(root.val));
        dfs(root.left, res, row + 1, left, mid - 1);
        dfs(root.right, res, row + 1, mid + 1, right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

