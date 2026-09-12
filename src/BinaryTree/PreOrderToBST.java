package BinaryTree;

import java.util.Scanner;

public class PreOrderToBST {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int index = 0;

    public static void main(String[] args) {

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] preorder = new int[n];

        System.out.println("Enter Preorder Traversal:");

        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }

        Node root = buildBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println("\nInorder Traversal (Should be Sorted):");
        inorder(root);

        System.out.println("\n\nPreorder Traversal:");
        preorderTraversal(root);
    }

    static Node buildBST(int[] preorder, int min, int max) {

        if (index >= preorder.length)
            return null;

        int value = preorder[index];

        if (value < min || value > max)
            return null;

        Node root = new Node(value);

        index++;

        root.left = buildBST(preorder, min, value);

        root.right = buildBST(preorder, value, max);

        return root;
    }

    static void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    static void preorderTraversal(Node root) {

        if (root == null)
            return;

        System.out.print(root.data + " ");

        preorderTraversal(root.left);

        preorderTraversal(root.right);
    }
}
