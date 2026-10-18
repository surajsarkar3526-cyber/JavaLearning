package BinarySearchTree;

import java.util.*;

public class AllNodesDistanceK {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode target = root.left;
        int k = 2;
        System.out.println(distanceK(root, target, k));
    }

    private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParent(root, parentMap);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int distance = 0;
        while (!queue.isEmpty()) {

            if (distance == k) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null
                        && visited.add(current.left)) {
                    queue.offer(current.left);
                }
                if (current.right != null
                        && visited.add(current.right)) {
                    queue.offer(current.right);
                }
                TreeNode parent = parentMap.get(current);
                if (parent != null && visited.add(parent)) {
                    queue.offer(parent);
                }
            }
            distance++;
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        return result;
    }

    private static void buildParent(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if(root == null){
            return;
        }
        if(root.left != null){
            parentMap.put(root.left, root);
            buildParent(root.left, parentMap);
        }
        if(root.right != null){
            parentMap.put(root.right, root);
            buildParent(root.right, parentMap);
        }
    }
}
