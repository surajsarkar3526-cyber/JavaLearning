package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }

    private static int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new int[]{v, w});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1])
        );
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currentDistance = current[1];
            if (currentDistance > dist[node]) {
                continue;
            }
            for (int[] edge : graph.get(node)) {
                int neighbour = edge[0];
                int weight = edge[1];
                int newDistance = currentDistance + weight;
                if (newDistance < dist[neighbour]) {
                    dist[neighbour] = newDistance;
                    pq.offer(new int[]{neighbour, newDistance});
                }
            }
        }
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}
