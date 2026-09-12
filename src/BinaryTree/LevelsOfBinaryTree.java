package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelsOfBinaryTree {

    static Scanner sc = new Scanner(System.in);

    static Node createTree() {
        System.out.print("Enter data (-1 for NULL): ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node root = new Node(data);

        System.out.println("Enter left child of " + data);
        root.left = createTree();

        System.out.println("Enter right child of " + data);
        root.right = createTree();

        return root;
    }

    static void printLevels(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            System.out.print("Level " + level + " : ");

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current == null) {
                    continue;
                }

                System.out.print(current.Data + " ");

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {
        Node root = createTree();

        System.out.println("\nLevels of Binary Tree:");
        printLevels(root);
    }
}
