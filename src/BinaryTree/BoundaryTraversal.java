package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BoundaryTraversal {

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

        ArrayList<Integer> ans = boundaryTraversal(root);
        System.out.println("Boundary Traversal : " + ans);
    }

    private static ArrayList<Integer> boundaryTraversal(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        if(!isLeaf(root)){
            ans.add(root.data);
        }

        addLeftBoundary(root, ans);

        addLeaves(root, ans);

        addRightBoundary(root, ans);

        return ans;
    }

    static void addRightBoundary(Node root, ArrayList<Integer> ans) {

        Node current = root.right;

        Stack<Integer> stack = new Stack<>();

        while (current != null) {

            if (!isLeaf(current))
                stack.push(current.data);

            if (current.right != null)
                current = current.right;
            else
                current = current.left;
        }

        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
    }

    static void addLeaves(Node root, ArrayList<Integer> ans) {

        if(root == null){
            return;
        }

        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }

        addLeaves(root.left, ans);
        addLeaves(root.right, ans);
    }

    static void addLeftBoundary(Node root, ArrayList<Integer> ans) {

        Node current = root.left;

        while(current != null){

            if(!isLeaf(current)){
                ans.add(current.data);
            }

            if(current.left != null){
                current = current.left;
            }

            else{
                current = current.right;
            }
        }
    }

    static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
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
