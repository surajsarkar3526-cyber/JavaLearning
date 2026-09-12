package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class RootToPathSum {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        Node root = createTree();

        System.out.print("Enter Target Sum: ");
        int target = sc.nextInt();

        ArrayList<ArrayList<Integer>> ans = printPaths(root, target);

        System.out.println(ans);
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

    static ArrayList<ArrayList<Integer>> printPaths(Node root, int target) {

        result.clear();

        ArrayList<Integer> path = new ArrayList<>();

        dfs(root, target, 0, path, result);

        return result;
    }

    static void dfs(Node root, int target, int sum,
                    ArrayList<Integer> path,
                    ArrayList<ArrayList<Integer>> ans) {

        if (root == null)
            return;

        sum += root.Data;
        path.add(root.Data);

        if (sum == target) {
            ans.add(new ArrayList<>(path));
        }

        dfs(root.left, target, sum, path, ans);
        dfs(root.right, target, sum, path, ans);

        path.removeLast();
    }
}
