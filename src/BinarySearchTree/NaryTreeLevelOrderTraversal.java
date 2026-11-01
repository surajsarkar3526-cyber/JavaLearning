package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    static class Node{
        int val;
        List<Node> children;
        Node(int val){
            this.val = val;
            children = new ArrayList<>();
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        root.children.add(n3);
        root.children.add(n2);
        root.children.add(n4);
        n3.children.add(new Node(5));
        n3.children.add(new Node(6));
        List<List<Integer>> ans = levelOrder(root);
        System.out.println(ans);
    }
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++){
                Node curr = queue.poll();
                level.add(curr.val);
                for(Node current : curr.children){
                    queue.add(current);
                }
            }
            result.add(level);
        }
        return result;
    }
}
