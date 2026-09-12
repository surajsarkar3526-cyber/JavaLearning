package BinaryTree;

import java.util.Scanner;

public class LowestCommonAncestor {

    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node createTree() {

        System.out.print("Enter Data (-1 for NULL): ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node root = new Node(data);

        System.out.println("Enter Left Child of " + data);
        root.left = createTree();

        System.out.println("Enter Right Child of " + data);
        root.right = createTree();

        return root;
    }

    public static void main(String[] args) {

        System.out.println("Create Binary Tree");
        Node root = createTree();

        System.out.print("Enter First Node: ");
        int n1 = sc.nextInt();

        System.out.print("Enter Second Node: ");
        int n2 = sc.nextInt();

        Node ans = lca(root, n1, n2);

        if (ans != null) {
            System.out.println("Lowest Common Ancestor = " + ans.data);
        }
    }

    static Node lca(Node root, int n1, int n2) {

        if(root == null){
            return null;
        }

        if(root.data == n1 || root.data == n2){
            return root;
        }

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if(left != null && right != null){
            return root;
        }

        if(left != null){
            return left;
        }

        else{
            return right;
        }
    }
}
