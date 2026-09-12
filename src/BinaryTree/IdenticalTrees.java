package BinaryTree;

import java.util.Scanner;

public class IdenticalTrees {
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

    static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.Data == root2.Data)
                && isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right);
    }

    public static void main(String[] args) {

        System.out.println("Create First Binary Tree");
        Node root1 = createTree();

        System.out.println("\nCreate Second Binary Tree");
        Node root2 = createTree();

        if (isIdentical(root1, root2))
            System.out.println("\nBoth Binary Trees are Identical.");

        else
            System.out.println("\nBoth Binary Trees are NOT Identical.");


        sc.close();
    }
}
