package BinaryTree;

import java.util.*;

public class ZigZagTraversal {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node buildTree() {
        System.out.print("Enter data (-1 for NULL): ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node root = new Node(data);

        System.out.println("Enter left child of " + data);
        root.left = buildTree();

        System.out.println("Enter right child of " + data);
        root.right = buildTree();

        return root;
    }

    static ArrayList<ArrayList<Integer>> zigZagTraversal(Node root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {

                Node current = queue.remove();

                if (leftToRight) {
                    level.addLast(current.data);
                }

                else {
                    level.addFirst(current.data);
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(new ArrayList<>(level));

            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println("Create Binary Tree");
        Node root = buildTree();

        ArrayList<ArrayList<Integer>> ans = zigZagTraversal(root);

        System.out.println("\nZig-Zag Traversal:");

        for (ArrayList<Integer> level : ans) {
            System.out.println(level);
        }

        sc.close();
    }
}
