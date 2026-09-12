package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTreePaths {

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

        List<String> paths = binaryTreePaths(root);

        System.out.println(paths);
    }

    private static List<String> binaryTreePaths(Node root) {
        List<String> result = new ArrayList<>();

        dfs(root,"",result);

        return result;
    }

    static void dfs(Node root, String path, List<String> result) {

        if(root == null){
            return;

        }

        if(path.isEmpty()){
            path = String.valueOf(root.data);
        }
        else{
            path = path + "->" + root.data;
        }

        if(root.left == null && root.right == null){
            result.add(path);
            return;

        }

        dfs(root.left, path, result);
        dfs(root.right, path, result);
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
