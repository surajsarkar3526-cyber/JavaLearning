package BinaryTree;

import java.util.Scanner;

public class SumOfBinaryTree {
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

    static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        return root.Data + sum(root.left) + sum(root.right);
    }

    public static void main(String[] args) {

        Node root = createTree();

        int total = sum(root);

        System.out.println("Sum of all nodes = " + total);
    }
}
