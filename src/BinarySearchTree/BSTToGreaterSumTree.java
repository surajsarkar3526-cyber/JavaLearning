package BinarySearchTree;

import java.util.Scanner;

public class BSTToGreaterSumTree {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int sum = 0;

    static Node bstToGST(Node root) {

        if (root == null)
            return null;

        bstToGST(root.right);

        sum += root.data;
        root.data = sum;

        bstToGST(root.left);

        return root;
    }

    static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        return root;
    }

    public static void main(String[] args) {

        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter values:");

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        System.out.print("Original BST (Inorder): ");
        inorder(root);

        sum = 0;
        root = bstToGST(root);

        System.out.print("\nGreater Sum Tree (Inorder): ");
        inorder(root);
    }
}
