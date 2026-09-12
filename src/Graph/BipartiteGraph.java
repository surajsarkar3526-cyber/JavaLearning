package Graph;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static boolean isBipartite(int V, int[][] edges) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int start = 0; start < V; start++) {

            if (color[start] != -1) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            color[start] = 0;
            queue.offer(start);
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : graph[node]) {
                    if (color[neighbor] == -1) {
                        color[neighbor] = 1 - color[node];
                        queue.offer(neighbor);
                    }
                    else if (color[neighbor] == color[node]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 3;
        int[][] edges = {
                {0, 1},
                {1, 2}
        };
        System.out.println(isBipartite(V, edges));
    }
}
