package BinarySearchTree;

public class SortedArrayToBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node sortedArrayToBST(int[] arr) {
        return buildBST(arr, 0, arr.length - 1);
    }

    static Node buildBST(int[] arr, int start, int end) {

        if(start > end){
            return null;
        }

        int mid = start + (end - start)/2;
        Node root = new Node(arr[mid]);

        root.left = buildBST(arr,start,mid-1);
        root.right = buildBST(arr, mid+1, end);

        return root;
    }

    static void inorder(Node root) {

        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    static void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);

    }
    public static void main(String[] args) {

        int[] arr = {-10, -3, 0, 5, 9};

        Node root = sortedArrayToBST(arr);

        System.out.print("Inorder : ");
        inorder(root);

        System.out.println();

        System.out.print("Preorder : ");
        preorder(root);
    }
}
