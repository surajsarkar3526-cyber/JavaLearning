package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeftViewBinaryTree {

    static Scanner sc = new Scanner(System.in);
    static class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
            left = right = null;
        }

    }

    public static void main(String[] args) {
        System.out.print("Create Binary Tree");
        Node root = createRoot();

        ArrayList<Integer> ans = leftView(root);

        System.out.println(ans);
    }

    static ArrayList<Integer> leftView(Node root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Node current = queue.remove();

                if (i == 0) {
                    result.add(current.value);
                }

                if (current.left != null)
                    queue.offer(current.left);

                if (current.right != null)
                    queue.offer(current.right);
            }
        }

        return result;
    }

    private static Node createRoot() {
        System.out.print("Enter Data (-1 for null) : ");
        int value = sc.nextInt();

        if (value == -1)
            return null;

        Node root = new Node(value);

        System.out.println("Enter left child of " + value);
        root.left = createRoot();

        System.out.println("Enter right child of " + value);
        root.right = createRoot();

        return root;
    }
}
