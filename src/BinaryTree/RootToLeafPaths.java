package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class RootToLeafPaths {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {
        System.out.println("Create Binary Tree");
        Node root = createTree();

        ArrayList<ArrayList<Integer>> paths = rootToLeafPaths(root);

        System.out.println("\nRoot to Leaf Paths:");
        for (ArrayList<Integer> path : paths) {
            System.out.println(path);
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

    static ArrayList<ArrayList<Integer>> rootToLeafPaths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        dFs(root,path,result);

        return result;
    }

    private static void dFs(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if(root == null){
            return;
        }
        path.add(root.data);

        if(root.left == null && root.right == null){
            result.add(new ArrayList<>(path));
        }

        else{
            dFs(root.left,path,result);
            dFs(root.right,path,result);
        }

        path.removeLast();
    }
}
