package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {

    static Scanner sc = new Scanner(System.in);

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        System.out.println("Create Binary Tree");
        Node root = buildTree(sc);

        ArrayList<Integer> result = levelOrder(root);

        System.out.println("\nLevel Order Traversal:");
        System.out.println(result);

        sc.close();
    }

    private static ArrayList<Integer> levelOrder(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();
            ans.add(current.data);

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        return ans;
    }

    private static Node buildTree(Scanner sc) {

        System.out.print("Enter data (-1 for null): ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node root = new Node(data);

        System.out.println("Enter left child of " + data);
        root.left = buildTree(sc);

        System.out.println("Enter right child of " + data);
        root.right = buildTree(sc);

        return root;
    }
}
