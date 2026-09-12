package BinarySearchTree;

import java.util.Scanner;

public class MaximumSumBST {

    static Scanner sc = new Scanner(System.in);
    static int maxSum = 0;

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
        int sum;
        int min;
        int max;

        Info(boolean isBST, int sum, int min, int max) {
            this.isBST = isBST;
            this.sum = sum;
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

            int currentSum = left.sum + right.sum + root.data;

            maxSum = Math.max(maxSum, currentSum);

            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);

            return new Info(true, currentSum, min, max);
        }

        return new Info(false,
                Math.max(left.sum, right.sum),
                0,
                0);
    }

    public static void main(String[] args) {

        System.out.println("Create Binary Tree");
        Node root = createTree();

        largestBST(root);

        System.out.println("Largest BST Size = " + maxSum);
    }
}
