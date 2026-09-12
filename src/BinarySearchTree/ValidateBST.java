package BinarySearchTree;

import java.util.Scanner;

public class ValidateBST {

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

    static class Pair{

        int max;
        int min;
        boolean isBST;

        Pair(int min, int max, boolean isBST){

            this.min = min;
            this.max = max;
            this.isBST = isBST;

        }
    }

    static Node createTree() {

        System.out.print("Enter Node(-1 for null) : ");

        int value = sc.nextInt();
        if(value == -1){
            return null;

        }

        Node root = new Node(value);
        System.out.println("Enter left Node of Value : " + value);
        root.left = createTree();

        System.out.println("Enter right Node of Value : "+ value);
        root .right = createTree();

        return root;
    }

        public static void main(String[] args){
        System.out.println("Create Binary Tree ");
        Node root = createTree();

        Pair ans = validateBST(root);

        if (ans.isBST) {
            System.out.println("Valid BST");
        }

        else {
            System.out.println("Not a BST");
        }
    }

    static Pair validateBST(Node root) {

        if(root == null){
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }

        Pair left = validateBST(root.left);
        Pair right = validateBST(root.right);

        if(left.isBST &&
                right.isBST &&
                root.data > left.max &&
                root.data < right.min
        ){

            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);

            return new Pair(min, max, true);
        }

        return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
    }
}
