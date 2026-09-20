package Graph;

import java.util.*;

public class MinimumHeightTrees {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3, 0},{3, 1},{3, 2},{3, 4},{5, 4}};
        List<Integer> result = findMinHeightTrees(n, edges);
        System.out.println("Minimum Height Tree Roots: " + result);
    }

    private static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return new ArrayList<>(Collections.singletonList(0));
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        int remainingNodes = n;
        while (remainingNodes > 2) {
            int size = queue.size();
            remainingNodes -= size;
            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();
                for (int neighbour : graph.get(leaf)) {
                    degree[neighbour]--;
                    if (degree[neighbour] == 1) {
                        queue.offer(neighbour);
                    }
                }
            }
        }
        return new ArrayList<>(queue);
    }
}
