package BinaryTree;

import java.util.Scanner;

public class MaximumValueBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Create Binary Tree ");
        Node root = CreateTree(sc);

        int max = findMaximum(root);

        if(max == Integer.MIN_VALUE){
            System.out.print("Tree is Empty!");
        }
        else{
            System.out.print("Maximum Value is "+max);
        }
    }

    private static int findMaximum(Node root) {
        if(root == null){
            return Integer.MIN_VALUE;
        }

        int leftMax = findMaximum(root.left);
        int rightMax = findMaximum(root.right);

        return Math.max(root.Data, Math.max(leftMax, rightMax));

    }

    private static Node CreateTree(Scanner sc) {
        System.out.print("Enter data (-1 for null) : ");
        int data = sc.nextInt();

        if(data == -1){
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter left child of "+data);
        root.left = CreateTree(sc);

        System.out.println("Enter right child of "+data);
        root.right = CreateTree(sc);

        return root;
    }
}
