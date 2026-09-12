package BinaryTree;

import java.util.Scanner;
import java.util.Stack;

public class InorderTraversal {

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

        System.out.print("Inorder Traversal: ");
        inorderIterative(root);
    }

    static void inorderIterative(Node root) {

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while(current != null || !stack.isEmpty()){

            while(current != null){
                stack.push(current);
                current = current.left;

            }

            current = stack.pop();
            System.out.print(current.data+" ");

            current = current.right;
        }
    }

    static Node createTree() {
        System.out.print("Enter data (-1 for NULL): ");
        int data = sc.nextInt();

        if (data == -1) {
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
