package BinaryTree;

import java.util.Scanner;

public class BinaryTreeSize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create Binary Tree");

        Node root = builtTree(sc);

        System.out.println("Size of Binary Tree = " + size(root));
    }

    private static int  size(Node root) {

        if(root == null){
            return 0;
        }

        return 1 + size(root.left) + size(root.right);
    }

    private static Node builtTree(Scanner sc) {
        System.out.print("Enter data (-1 for null) : ");
        int data = sc.nextInt();

        if(data == -1){
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter left child of "+data);
        root.left = builtTree(sc);

        System.out.println("Enter right child of "+data);
        root.right = builtTree(sc);

        return root;
    }
}
