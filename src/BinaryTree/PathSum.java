package BinaryTree;

import java.util.Scanner;

public class PathSum {

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

        System.out.println("Enter Left of " + data);
        root.left = createTree();

        System.out.println("Enter Right of " + data);
        root.right = createTree();

        return root;
    }

    static boolean hasPathSum(Node root, int targetSum) {

        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return targetSum == root.data;
        }

        int remaining = targetSum - root.data;

        return hasPathSum(root.left, remaining)
                || hasPathSum(root.right, remaining);
    }

    public static void main(String[] args) {

        System.out.println("Create Binary Tree");
        Node root = createTree();

        System.out.print("Enter Target Sum: ");
        int target = sc.nextInt();

        if (hasPathSum(root, target)) {
            System.out.println("Path Exists");
        }

        else {
            System.out.println("Path Does Not Exist");
        }
    }
}
