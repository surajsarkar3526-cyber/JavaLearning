package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VerticalOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Info {
        TreeNode node;
        int row;
        int col;

        Info(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        VerticalOrderTraversal solution = new VerticalOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(solution.verticalTraversal(root));
    }

    private List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(root, 0, 0));
        while (!queue.isEmpty()) {
            Info info = queue.poll();
            nodes.add(new int[]{
                    info.col, info.row, info.node.val
            });
            if (info.node.left != null) {
                queue.offer(new Info(
                        info.node.left,
                        info.row + 1,
                        info.col - 1
                ));
            }
            if (info.node.right != null) {
                queue.offer(new Info(
                        info.node.right,
                        info.row + 1,
                        info.col + 1
                ));
            }
        }
        nodes.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });
        List<List<Integer>> result = new ArrayList<>();
        int previousCol = Integer.MIN_VALUE;
        for (int[] node : nodes) {
            int col = node[0];
            int value = node[2];
            if (col != previousCol) {
                result.add(new ArrayList<>());
                previousCol = col;
            }
            result.get(result.size() - 1).add(value);
        }
        return result;
    }
}
