package BinarySearchTree;

import java.util.Scanner;

public class LargestBST {

    static Scanner sc = new Scanner(System.in);
    static int maxBST = 0;

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

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
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

    static Info largestBST(Node root) {

        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = largestBST(root.left);
        Info right = largestBST(root.right);

        if (left.isBST &&
                right.isBST &&
                root.data > left.max &&
                root.data < right.min) {

            int size = left.size + right.size + 1;

            maxBST = Math.max(maxBST, size);

            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);

            return new Info(true, size, min, max);
        }

        return new Info(false,
                Math.max(left.size, right.size),
                Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    public static void main(String[] args) {

        System.out.println("Create Binary Tree");
        Node root = createTree();

        largestBST(root);

        System.out.println("Largest BST Size = " + maxBST);
    }
}
