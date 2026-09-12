package BinarySearchTree;

import java.util.Scanner;

public class SearchInBST {

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

    static Node search(Node root, int key) {

        if(root == null || root.data == key){
            return root;
        }

        if(key < root.data){
            return search(root.left, key);
        }

        else{
            return search(root.right, key);
        }

    }

    static void inorder(Node root) {
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }
    public static void main(String[] args) {

        Node root = null;

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter BST Elements:");

        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        System.out.print("\nInorder Traversal: ");
        inorder(root);

        System.out.print("\nEnter value to search: ");
        int key = sc.nextInt();

        Node ans = search(root, key);

        if (ans != null) {
            System.out.println(key + " Found in BST.");
        }

        else {
            System.out.println(key + " Not Found.");
        }
    }
}
