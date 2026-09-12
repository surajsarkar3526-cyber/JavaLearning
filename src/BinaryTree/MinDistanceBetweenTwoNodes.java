package BinaryTree;

import java.util.Scanner;

public class MinDistanceBetweenTwoNodes {

    static Scanner sc = new Scanner(System.in);

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        System.out.println("Create Binary Tree");
        Node root = buildTree(sc);

        System.out.print("Enter First Node : ");
        int a = sc.nextInt();

        System.out.print("Enter Second Node : ");
        int b = sc.nextInt();

        int ans = minDistance(root, a, b);
        System.out.println("Minimum Distance : " + ans);
    }

    static int minDistance(Node root, int a, int b) {
        Node lca = findLCA(root,a,b);

        int d1 = findDistance(lca, a, 0);
        int d2 = findDistance(lca, b, 0);

        return d1 + d2;
    }

    static int findDistance(Node root, int target, int distance) {
        if(root == null){
            return -1;
        }

        if(target == root.data){
            return distance;
        }

        int left = findDistance(root.left, target, distance);
        if(left != -1){
            return left;
        }

        return findDistance(root.right, target, distance);
    }

    static Node findLCA(Node root, int a, int b) {
        if(root == null){
            return null;
        }
        if(root.data == a || root.data == b){
            return root;
        }

        Node left = findLCA(root.left, a, b);
        Node right = findLCA(root.right, a, b);

        if(left != null && right != null){
            return root;
        }

        return (left !=null)? left: right;
    }

    private static Node buildTree(Scanner sc) {

        System.out.print("Enter data (-1 for null): ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node root = new Node(data);

        System.out.println("Enter left child of " + data);
        root.left = buildTree(sc);

        System.out.println("Enter right child of " + data);
        root.right = buildTree(sc);

        return root;
    }
}

