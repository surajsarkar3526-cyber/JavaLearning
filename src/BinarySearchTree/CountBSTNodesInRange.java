package BinarySearchTree;

import java.util.Scanner;

public class CountBSTNodesInRange {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insert(Node root, int data) {
        if(root == null){
            return new Node(data);
        }

        if(data < root.data){
            insert(root.left,  data);
        }

        else{
            insert(root.right, data);
        }

        return root;
    }

    static int countInRange(Node root, int low, int high) {

        if (root == null) {
            return 0;
        }

        if (root.data < low) {
            return countInRange(root.right, low, high);
        }

        if (root.data > high) {
            return countInRange(root.left, low, high);
        }

        return 1
                + countInRange(root.left, low, high)
                + countInRange(root.right, low, high);
    }
    public static void main(String[] args) {

        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter BST elements:");

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        System.out.print("Enter lower limit: ");
        int low = sc.nextInt();

        System.out.print("Enter upper limit: ");
        int high = sc.nextInt();

        int count = countInRange(root, low, high);

        System.out.println("Nodes in range = " + count);
    }
}
