package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    static class CBTInserter {
        private TreeNode root;
        private Queue<TreeNode> queue;
        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new LinkedList<>();
            Queue<TreeNode> bfs = new LinkedList<>();
            bfs.offer(root);
            while (!bfs.isEmpty()) {
                TreeNode current = bfs.poll();
                if (current.left != null) {
                    bfs.offer(current.left);
                }
                if (current.right != null) {
                    bfs.offer(current.right);
                }
                if (current.left == null || current.right == null) {
                    queue.offer(current);
                }
            }
        }
        public int insert(int val) {
            TreeNode parent = queue.peek();
            TreeNode newNode = new TreeNode(val);
            if (parent.left == null) {
                parent.left = newNode;
            }
            else {
                parent.right = newNode;
                queue.poll();
            }
            queue.offer(newNode);
            return parent.val;
        }
        public TreeNode get_root() {
            return root;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        CBTInserter inserter = new CBTInserter(root);
        System.out.println(inserter.insert(3));
        System.out.println(inserter.insert(4));
        TreeNode result = inserter.get_root();
        System.out.println(result.val + ", " + result.left.val + ", " + result.right.val + ", " + result.left.left.val);
    }
}
