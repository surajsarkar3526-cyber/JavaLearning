package HashMap;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumTimeToBurnBinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.left = new Node(6);

        int target = 5;

        System.out.println("Minimum time = "
                + minTime(root, target));
    }

    static int minTime(Node root, int target) {

        HashMap<Node,Node> parentMap = new HashMap<>();

        Node targetNode = markParents(root, target, parentMap);
        if (targetNode == null) {
            return 0;
        }

        HashMap<Node,Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(targetNode);
        boolean burned;
        visited.put(targetNode, true);

        int time = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            burned = false;

            for(int i=0; i<size; i++){

                Node current = queue.poll();

                if(current == null){
                    return 0;
                }

                if(current.left != null &&
                        !visited.containsKey(current.left)){

                    queue.offer(current.left);
                    visited.put(current.left, true);
                    burned = true;
                }
                if(current.right != null &&
                        !visited.containsKey(current.right)){

                    queue.offer(current.right);
                    visited.put(current.right, true);
                    burned = true;
                }

                if(parentMap.containsKey(current)){

                    Node parent = parentMap.get(current);
                    if(!visited.containsKey(parent)){

                        queue.offer(parent);
                        visited.put(parent, true);
                        burned = true;
                    }
                }
            }
            if(burned) {
                time++;
            }
        }

        return time;
    }

    static Node markParents(Node root, int target,
                            HashMap<Node, Node> parentMap) {
        Queue<Node> queue =  new ArrayDeque<>();
        queue.offer(root);

        Node targetNode = null;

        while(!queue.isEmpty()){

            Node current = queue.poll();
            if(current.data == target){
                targetNode = current;
            }

            if(current.left != null){
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }

            if(current.right != null){
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }

        return targetNode;
    }
}
