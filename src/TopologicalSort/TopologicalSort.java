package TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    public static void main(String[] args) {
        int vertices = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(0).add(3);
        graph.get(1).add(3);
        graph.get(3).add(2);
        int[] indegree = new int[vertices];
        for(int u=0; u<vertices; u++){
            for(int v : graph.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<vertices; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        List<Integer>order = new ArrayList<>();
        while(!queue.isEmpty()){
            int u = queue.poll();
            order.add(u);
            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (order.size() != vertices) {
            System.out.println("Topological sort not possible: cycle exists");
        }
        else {
            System.out.println(order);
        }
    }
}
