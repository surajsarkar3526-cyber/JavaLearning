package BinaryTree;

import java.util.Scanner;

public class BinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create a Binary Tree");
        Node root = buildTree(sc);

        System.out.println("Inorder Traversal ");
        Inorder(root);

        System.out.println("preorder Traversal ");
        preOrder(root);

        System.out.println("PostOrder Traversal ");
        postOrdered(root);

        sc.close();

    }

    private static void postOrdered(Node root) {
        if(root == null){
            return;
        }

        postOrdered(root.left);
        postOrdered(root.right);
        System.out.println(root.Data);
    }

    private static void preOrder(Node root) {
        if(root == null){
            return;
        }

        System.out.println(root.Data);
        preOrder(root.left);
        preOrder(root.right);

    }

    private static void Inorder(Node root) {
        if(root == null){
            return;
        }

        Inorder(root.left);
        System.out.println(root.Data);
        Inorder(root.right);

    }

    private static Node buildTree(Scanner sc) {
        System.out.print("Enter data (-1 for null) : ");
        int data = sc.nextInt();

        if(data == -1){
            return null;
        }

        Node root = new Node(data);
        System.out.println("Enter left child of "+data);
        root.left = buildTree(sc);

        System.out.println("Enter right child of "+data);
        root.right = buildTree(sc);

        return root;

    }
}
