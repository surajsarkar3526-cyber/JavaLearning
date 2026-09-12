package BinarySearchTree;

import java.util.Scanner;

public class LCAinBST {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
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

    static Node lca(Node root, int n1, int n2) {

        if (root == null)
            return null;

        if (n1 < root.data && n2 < root.data)
            return lca(root.left, n1, n2);

        if (n1 > root.data && n2 > root.data)
            return lca(root.right, n1, n2);

        return root;
    }

    public static void main(String[] args) {

        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        System.out.print("Enter first node: ");
        int n1 = sc.nextInt();

        System.out.print("Enter second node: ");
        int n2 = sc.nextInt();

        Node ans = lca(root, n1, n2);

        if (ans != null)
            System.out.println("LCA = " + ans.data);

        else
            System.out.println("LCA not found");
    }
}
