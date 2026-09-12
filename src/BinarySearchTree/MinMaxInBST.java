package BinarySearchTree;

import java.util.Scanner;

public class MinMaxInBST {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Node root = null;

        System.out.print("How many nodes? ");
        int n = sc.nextInt();

        System.out.println("Enter Nodes:");

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            root = insert(root, x);
        }

        System.out.print("Inorder Traversal: ");
        inorder(root);

        System.out.println();

        System.out.println("Minimum Element = " + findMin(root));
        System.out.println("Maximum Element = " + findMax(root));
    }

    static int findMax(Node root) {

        if(root == null){
            throw new RuntimeException("BST is Empty!");
        }
        while(root.left != null){
            root = root.left;
        }

        return root.data;
    }

    static int findMin(Node root) {

        if(root == null){
            throw new RuntimeException("BST is Empty!");
        }

        while(root.right != null){
            root = root.right;
        }

        return root.data;
    }

    static void inorder(Node root) {
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

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
}
