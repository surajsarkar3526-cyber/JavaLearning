package BinaryTree;
class Node{
    int Data;
    Node left;
    Node right;

    Node(int val){
        this.Data = Data;
        left = null;
        right = null;
    }
}
public class Implementation {
    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        display(a);
    }

    private static void display(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.Data+" ");
        display(root.left);
        display(root.right);
    }
}
