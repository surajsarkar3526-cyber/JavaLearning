package BinaryTree;

import java.util.Scanner;

public class SameTree {

    static Scanner sc = new Scanner(System.in);

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

    static boolean isSameTree(Node p, Node q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.Data != q.Data) {
            return false;
        }

        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        System.out.println("Create First Tree");
        Node root1 = createTree();

        System.out.println("\nCreate Second Tree");
        Node root2 = createTree();

        if (isSameTree(root1, root2)) {
            System.out.println("\nBoth Trees are Same.");
        } else {
            System.out.println("\nBoth Trees are Not Same.");
        }

        sc.close();
    }
}
