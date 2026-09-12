package BinaryTree;

import java.util.Scanner;

public class BalancedBinaryTree {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        System.out.println("Create Binary Tree");
        Node root = createTree();

        if (isBalanced(root)) {
            System.out.println("\nBalanced Binary Tree");
        }

        else {
            System.out.println("\nNot a Balanced Binary Tree");
        }
    }

    private static Node createTree() {
        System.out.print("Enter Data (-1 for null) : ");
        int value = sc.nextInt();

        if (value == -1)
            return null;

        Node root = new Node(value);

        System.out.println("Enter left child of " + value);
        root.left = createTree();

        System.out.println("Enter right child of " + value);
        root.right = createTree();

        return root;
    }
    static boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    static int checkHeight(Node root) {

        if(root == null){
            return 0;
        }
        int leftHeights = checkHeight(root.left);
        if(leftHeights == -1){
            return -1;
        }

        int rightHeights = checkHeight(root.right);
        if(rightHeights == -1){
            return -1;
        }

        if(Math.abs(leftHeights - rightHeights) > 1){
            return -1;
        }

        return Math.max(leftHeights, rightHeights) + 1;
    }
}
