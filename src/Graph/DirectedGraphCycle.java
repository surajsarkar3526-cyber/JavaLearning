package Graph;

import java.util.ArrayList;

public class DirectedGraphCycle {
    static boolean dfs(
            int node,
            ArrayList<ArrayList<Integer>> graph,
            boolean[] visited,
            boolean[] pathVisited
    ) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (pathVisited[neighbor]) {
                return true;
            }
            if (!visited[neighbor]) {
                if (dfs(neighbor, graph, visited, pathVisited)) {
                    return true;
                }
            }
        }
        pathVisited[node] = false;
        return false;
    }
    static boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, graph, visited, pathVisited)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 0},
                {2, 3}
        };
        System.out.println(isCyclic(V, edges));
    }
}
