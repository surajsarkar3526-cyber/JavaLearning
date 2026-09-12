package Heap;

import java.util.ArrayList;

public class BSTToMaxHeap {

    static ArrayList<Integer> list = new ArrayList<>();
    static int index = 0;

    public static void main(String[] args) {

        Node root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(6);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right.left = new Node(5);
        root.right.right = new Node(7);

        convertToMaxHeap(root);

        System.out.println("Preorder of Max Heap:");

        preorder(root);
    }

    static void preorder(Node root) {
        if(root == null){
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    static void convertToMaxHeap(Node root) {

        list.clear();
        index = 0;

        inorder(root);
        fillPostorder(root);
    }

    static void inorder(Node root) {
        if(root == null){
            return;
        }

        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
    }

    static void fillPostorder(Node root) {
        if(root == null){
            return;
        }

        fillPostorder(root.left);
        fillPostorder(root.right);

        root.data = list.get(index);
        index++;
    }
}
