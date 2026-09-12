package BinaryTree;

import java.util.Scanner;
import java.util.Stack;

public class PreorderIterative {

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
        System.out.println("Create Binary Tree");
        Node root = createTree();

        preorder(root);
    }

    static void preorder(Node root) {
        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){

            Node current = stack.pop();

            if(current.right != null){
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }
        }
    }

    static Node createTree() {
        System.out.print("Enter data (-1 for NULL): ");
        int data = sc.nextInt();

        if(data == -1){
            return null;
        }
        Node root = new Node(data);

        System.out.println("Enter left child of " + data);
        root.left = createTree();

        System.out.println("Enter right child of " + data);
        root.right = createTree();

        return root;
    }
}
