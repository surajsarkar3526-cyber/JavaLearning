package BinarySearchTree;

import java.util.Scanner;

public class CheckBST {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node createTree() {

        System.out.print("Enter Data (-1 for NULL): ");
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

    static boolean isBST(Node root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean check(Node root, long min, long max) {

        if (root == null)
            return true;

        if (root.data <= min || root.data >= max)
            return false;

        return check(root.left, min, root.data)
                && check(root.right, root.data, max);
    }

    public static void main(String[] args) {

        System.out.println("Create Binary Tree");

        Node root = createTree();

        if (isBST(root))
            System.out.println("It is a BST");
        else
            System.out.println("It is NOT a BST");
    }
}
