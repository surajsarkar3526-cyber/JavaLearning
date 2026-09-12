package BinarySearchTree;

import java.util.Scanner;

public class DeleteNodeBST {

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

        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter BST elements:");

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            root = insert(root, value);
        }

        System.out.print("\nBST (Inorder): ");
        inorder(root);

        System.out.print("\n\nEnter node to delete: ");
        int key = sc.nextInt();

        root = delete(root, key);

        System.out.print("\nBST after deletion: ");
        inorder(root);


        sc.close();
    }

    static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static Node insert(Node root, int key) {

        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        }

        else if (key > root.data) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    static Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            root.left = delete(root.left, key);
        }
        else if (key > root.data) {
            root.right = delete(root.right, key);
        }
        else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    static Node findMin(Node root) {

        while(root.left != null){
            root = root.left;
        }

        return root;
    }
}
