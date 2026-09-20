package Graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.LinkedList;

public class CloneGraph {
    static class Node{
        int val;
        List<Node> neighbors;

        Node(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node clonedGraph = cloneGraph(node1);
        printGraph(clonedGraph);
    }

    private static void printGraph(Node root) {
        if(root == null){
            return;
        }
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        visited.add(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.val+" ");
            for(Node ele : current.neighbors){
                System.out.print(ele.val);
                if(!visited.contains(ele)){
                    visited.add(ele);
                    queue.offer(ele);
                }
                System.out.println();
            }
        }
    }

    private static Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        return DFs(node, map);
    }

    private static Node DFs(Node node, Map<Node, Node> map) {
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node clone = new Node(node.val);
        map.put(node,clone);
        for(Node ele : node.neighbors){
            clone.neighbors.add(DFs(ele,map));
        }
        return clone;
    }
}
