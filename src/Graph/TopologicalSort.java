package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[V];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
                {3, 0},
                {1, 0},
                {2, 0}
        };
        ArrayList<Integer> result = topoSort(V, edges);
        System.out.println(result);
    }
}
