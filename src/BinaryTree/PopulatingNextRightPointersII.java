package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersII {
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        connect(root);

        Node levelStart = root;
        while(levelStart != null){
            Node current = levelStart;
            while(current != null){
                System.out.println(current.val+"->");
                current = current.next;
            }
            System.out.println("Null");
            if(levelStart.next != null){
                levelStart = levelStart.left;
            }
            else if(levelStart.right != null){
                levelStart = levelStart.right;
            }
            else{
                break;
            }
        }
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
