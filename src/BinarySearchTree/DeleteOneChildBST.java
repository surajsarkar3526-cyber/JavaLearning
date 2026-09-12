package BinarySearchTree;

import java.util.Scanner;

public class DeleteOneChildBST {

    static Scanner sc = new Scanner(System.in);

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

    static Node insert(Node root, int key) {

        if (root == null)
            return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        return root;
    }

    static Node delete(Node root, int key) {

        if (root == null)
            return null;

        if (key < root.data) {
            root.left = delete(root.left, key);
        }

        else if (key > root.data) {
            root.right = delete(root.right, key);
        }

        else {

            if (root.left == null && root.right != null) {
                return root.right;
            }

            if(root.left != null && root.right == null){
                return root.left;
            }
        }

        return root;
    }

    static void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = null;

        int[] arr = {50, 30, 70, 20, 40, 60, 80};

        for (int x : arr)
            root = insert(root, x);

        System.out.println("Before Deletion:");
        inorder(root);

        root = delete(root, 20);

        System.out.println("\nAfter Deleting Leaf Node:");
        inorder(root);

        sc.close();
    }
}
