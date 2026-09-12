package BinaryTree;

import java.util.Scanner;

public class MirrorTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create a Binary Tree");
        Node root = buildTree(sc);

        System.out.print("\nPreorder Before Mirror: ");
        preOrder(root);

        mirror(root);

        System.out.print("\nPreorder After Mirror: ");
        preOrder(root);

        sc.close();

    }

    private static void mirror(Node root) {
        if(root == null){
            return;
        }

        mirror(root.left);
        mirror(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.Data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }

    private static Node buildTree(Scanner sc) {
        System.out.print("Enter data (-1 for null) : ");
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
