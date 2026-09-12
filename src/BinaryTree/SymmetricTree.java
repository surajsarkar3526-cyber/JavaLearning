package BinaryTree;

import java.util.Scanner;

public class SymmetricTree {

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

    static boolean isMirror(Node t1, Node t2) {

        if (t1 == null && t2 == null)
            return true;

        if (t1 == null || t2 == null)
            return false;

        return (t1.Data == t2.Data)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    static boolean isSymmetric(Node root) {

        if (root == null)
            return true;

        return isMirror(root.left, root.right);
    }

    static void preOrder(Node root) {

        if (root == null)
            return;

        System.out.print(root.Data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {

        System.out.println("Create Binary Tree");
        Node root = createTree();

        System.out.print("\nPreorder Traversal: ");
        preOrder(root);

        if (isSymmetric(root))
            System.out.println("\nTree is Symmetric.");
        else
            System.out.println("\nTree is NOT Symmetric.");

        sc.close();
    }
}
