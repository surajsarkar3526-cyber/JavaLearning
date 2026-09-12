package Heap;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}
public class IsBinaryTreeHeap {

    public static void main(String[] args) {

        Node root = new Node(97);

        root.left = new Node(46);
        root.right = new Node(37);

        root.left.left = new Node(12);
        root.left.right = new Node(3);

        root.right.left = new Node(7);
        root.right.right = new Node(31);

        root.left.left.left = new Node(6);
        root.left.left.right = new Node(9);

        System.out.println(isBinaryTreeHeap(root));
    }

    static boolean isBinaryTreeHeap(Node root) {

        if(root == null){
            return true;
        }
        return isComplete(root) && isHeap(root);
    }

    static boolean isHeap(Node root) {

        if(root == null){
            return true;
        }

        if(root.left != null && root.data < root.left.data){
            return false;
        }
        if(root.right != null && root.data < root.right.data){
            return false;
        }

        return isHeap(root.left) && isHeap(root.right);
    }

    static boolean isComplete(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundNull = false;
        while(!queue.isEmpty()){

            Node current = queue.poll();
            if(current == null){
                foundNull = true;
            }
            else{

                if(foundNull){
                    return false;
                }
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        return true;
    }
}
