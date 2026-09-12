package BinarySearchTree;

import java.util.Scanner;

public class FlattenBinaryTree {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter Tree (-1 for NULL)");

        Node root = createTree();

        flatten(root);

        System.out.println("Flattened Linked List:");

        printList(root);
    }

    static void flatten(Node root) {

        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        Node temp = root.right;

        root.right = root.left;
        root.left = null;

        Node current = root;

        while (current.right != null) {
            current = current.right;
        }

        current.right = temp;
    }

    static void printList(Node root) {

        while(root != null){
            System.out.print(root.data+" ");
            root = root.right;
        }
    }
    static Node createTree() {
        System.out.print("Enter data (-1 for NULL): ");
        int data = sc.nextInt();

        if (data == -1)
            return null;

        Node root = new Node(data);

        System.out.println("Left of " + data);
        root.left = createTree();

        System.out.println("Right of " + data);
        root.right = createTree();

        return root;
    }
}
