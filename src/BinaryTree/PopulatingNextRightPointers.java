package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointers {
    static class Node{
        int val;
        Node left;
        Node right;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        connect(root);
        System.out.println(root.val + " -> " + root.next);
        System.out.println( root.left.val + " -> " + root.left.next.val );
        System.out.println( root.right.val + " -> " + root.right.next );
        System.out.println( root.left.left.val + " -> " + root.left.left.next.val );
        System.out.println( root.left.right.val + " -> " + root.left.right.next.val );
        System.out.println( root.right.left.val + " -> " + root.right.left.next.val );
        System.out.println( root.right.right.val + " -> " + root.right.right.next );
    }

    private static Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node previous = null;
            for(int i=0; i<size; i++){
                Node current = queue.poll();
                if(previous != null){
                    previous.next = current;
                }
                previous = current;
                if(current.left != null){
                    queue.offer(current.left);
                }
                if(current.right != null){
                    queue.offer(current.right);
                }
            }
            previous.next = null;
        }
        return root;
    }
}
