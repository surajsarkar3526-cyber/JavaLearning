package BinaryTree;

import java.util.Scanner;

public class DiameterOfBinaryTree {

    static Scanner sc = new Scanner(System.in);

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }

    }

    static int diameter = 0;

    public static void main(String[] args) {
        System.out.println("Create Binary Tree");
        Node root = buildTree();

        diameterOfBinaryTree(root);

        System.out.println("Diameter of Binary Tree = " + diameter);
    }

    static int diameterOfBinaryTree(Node root) {
        if(root == null){
            return 0;
        }

        int leftHeights = diameterOfBinaryTree(root.left);
        int rightHeights = diameterOfBinaryTree(root.right);
        diameter = Math.max(diameter, (leftHeights+rightHeights));

        return Math.max(leftHeights,rightHeights)+1;
    }

    private static Node buildTree() {
        System.out.print("Enter data (-1 for null) : ");
        int value = sc.nextInt();

        if(value == -1){
            return null;
        }
        Node root = new Node(value);
        System.out.println("Enter left value of "+value);
        root.left = buildTree();

        System.out.println("Enter right value of "+value);
        root.right = buildTree();

        return root;
    }
}
