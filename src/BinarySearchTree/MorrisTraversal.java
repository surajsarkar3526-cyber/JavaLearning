package BinarySearchTree;

import java.util.Scanner;

public class MorrisTraversal {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node createTree() {

        System.out.print("Enter Data: ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node root = new Node(data);

        System.out.println("Left of " + data);
        root.left = createTree();

        System.out.println("Right of " + data);
        root.right = createTree();

        return root;
    }

    public static void main(String[] args) {

        System.out.println("Create Binary Tree");
        Node root = createTree();

        System.out.print("Morris Inorder Traversal: ");
        morrisInorder(root);
    }

    static void morrisInorder(Node root) {

        Node current = root;
        while(current != null){

            if(current.left == null){
                System.out.print(current.data);
                current = current.right;
            }

            else{

                Node predecessor = current.left;

                while(predecessor.right != null &&
                        predecessor.right != current
                ){
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null){

                    predecessor.right = current;
                    current = current.left;
                }

                else{
                    predecessor.right = null;
                    System.out.print(current.data+" ");
                    current = current.right;
                }
            }
        }
    }
}
