package BinaryTree;

public class FlattenBinaryTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private static Node prev = null;

    public static void flatten(Node root) {

        if (root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
    }

    public static void display(Node root) {

        while (root != null) {
            System.out.print(root.data);

            if (root.right != null) {
                System.out.print(" -> ");
            }

            root = root.right;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.right = new Node(6);

        System.out.println("Before Flatten:");
        System.out.println("""
        1
       / \\
      2   5
     / \\   \\
    3   4   6
    """);

        flatten(root);

        System.out.println("After Flatten:");
        display(root);
    }
}