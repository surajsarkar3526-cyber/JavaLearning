package BinarySearchTree;

import java.util.Scanner;

public class KthSmallestBST {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int count = 0;
    static int ans = -1;

    static Node insert(Node root, int key) {

        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        }

        else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    static void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void kthSmallest(Node root, int k) {
        if (root == null || ans != -1)
            return;
        kthSmallest(root.left, k);
        count++;
        if (count == k) {
            ans = root.data;
            return;
        }
        kthSmallest(root.right, k);
    }

    public static void main(String[] args) {

        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter BST elements:");

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        System.out.print("Inorder Traversal: ");
        inorder(root);

        System.out.print("\nEnter k: ");
        int k = sc.nextInt();

        count = 0;
        ans = -1;

        kthSmallest(root, k);

        if (ans == -1)
            System.out.println("Invalid k");
        else
            System.out.println(k + "th Smallest Element = " + ans);
    }
}
