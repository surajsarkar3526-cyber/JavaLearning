package Graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraphCycle {
    static class Pair{
        int node;
        int parent;
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {2, 3}
        };
        System.out.println(isCycle(V, edges));
    }

    private static boolean isCycle(int V, int[][] edges) {

        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] graph = new LinkedList[V];
        for(int i=0; i<V; i++){
            graph[i] = new LinkedList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                Queue<Pair> queue = new ArrayDeque<>();
                queue.offer(
                        new Pair(i, -1)
                );
                visited[i] = true;
                while(!queue.isEmpty()){
                    Pair current = queue.remove();
                    int node = current.node;
                    int parent = current.parent;
                    for(int neighbor : graph[node]){
                        if(!visited[neighbor]){
                            queue.offer(
                                    new Pair(neighbor, node)
                            );
                            visited[neighbor] = true;
                        }
                        else if(neighbor != parent){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
