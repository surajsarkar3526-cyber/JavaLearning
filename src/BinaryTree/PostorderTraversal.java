package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PostorderTraversal {

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

        System.out.print("Postorder Traversal: ");
        System.out.println(postorder(root));
        
    }

    static ArrayList <Integer> postorder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while(!stack1.isEmpty()){

            Node current = stack1.pop();
            stack2.push(current);

            if(current.left != null){
                stack1.push(current.left);
            }

            if(current.right != null){
                stack1.push(current.right);
            }
        }
        while(!stack2.isEmpty()){
            result.add(stack2.pop().data);
        }

        return result;
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
