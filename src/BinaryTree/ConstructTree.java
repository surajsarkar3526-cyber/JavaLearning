package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static int preIndex = 0;

    public static Node buildTree(int[] inorder, int[] preorder) {
        preIndex = 0;
        return construct(inorder, preorder, 0, inorder.length - 1);
    }

    private static Node construct(int[] inorder, int[] preorder,
                                  int inStart, int inEnd) {

        if (inStart > inEnd) {
            return null;
        }

        Node root = new Node(preorder[preIndex++]);

        if (inStart == inEnd) {
            return root;
        }

        int index = search(inorder, inStart, inEnd, root.data);

        root.left = construct(inorder, preorder, inStart, index - 1);

        root.right = construct(inorder, preorder, index + 1, inEnd);

        return root;
    }

    private static int search(int[] inorder, int start, int end, int value) {

        for (int i = start; i <= end; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }


    public static void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }


    public static void postorder(Node root) {

        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {

        int[] inorder = {3, 1, 4, 0, 5, 2};
        int[] preorder = {0, 1, 3, 4, 2, 5};

        Node root = buildTree(inorder, preorder);

        System.out.println("Inorder Traversal:");
        inorder(root);

        System.out.println("\n");

        System.out.println("Preorder Traversal:");
        preorder(root);

        System.out.println("\n");

        System.out.println("Postorder Traversal:");
        postorder(root);

        System.out.println("\n");

        System.out.println("Level Order Traversal:");
        levelOrder(root);
    }
}