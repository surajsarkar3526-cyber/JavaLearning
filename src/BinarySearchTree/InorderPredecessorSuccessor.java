package BinarySearchTree;

import java.util.Scanner;

public class InorderPredecessorSuccessor {

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

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(70);

        root.left.left = new Node(20);
        root.left.right = new Node(40);

        root.right.left = new Node(60);
        root.right.right = new Node(80);

        System.out.print("Enter Key : ");
        int key = sc.nextInt();

        Node pre = inorderPredecessor(root, key);
        Node suc = inorderSuccessor(root, key);

        System.out.println("Node : "+key);

        System.out.print("Predecessor : ");
        if(pre != null){
            System.out.println(pre.data);
        }
        else{
            System.out.println("NULL");
        }

        System.out.println("Successor : ");
        if(suc != null){
            System.out.println(suc.data);
        }
        else{
            System.out.println("NULL");
        }

        sc.close();
    }

    static Node inorderSuccessor(Node root, int key) {

        Node Successor = null;

        while(root != null){

            if(key < root.data){
                Successor = root;
                root = root.left;
            }

            else if(key > root.data){
                root = root.right;
            }

            else{

                if(root.right != null){
                    Node temp = root.right;

                    while(temp.left != null){
                        temp = temp.left;
                    }
                    Successor = temp;
                }
                break;
            }
        }

        return Successor;
    }

    static Node inorderPredecessor(Node root, int key) {

        Node Predecessor = null;

        while(root != null){

            if(key > root.data){
                Predecessor = root;
                root = root.right;
            }

            else if(key < root.data){
                root = root.left;
            }

            else{

                if(root.left != null){
                    Node current = root.left;

                    while(current.right != null){
                        current = current.right;
                    }
                    Predecessor = current;
                }
                break;
            }
        }

        return Predecessor;
    }
}
