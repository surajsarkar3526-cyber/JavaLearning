package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountConnectedSubgraphsWithEvenNodeSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1};
        int[][] edges = {
                {0, 1},
                {1, 2}
        };
        System.out.println(countConnectedSubgraphs(nums, edges));
    }

    private static int countConnectedSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;
        int answer = 0;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int mask = 1; mask < (1 << n); mask++) {
            int start = -1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    start = i;
                    break;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];
            queue.offer(start);
            visited[start] = true;
            int visitedCount = 0;
            int sum = 0;
            while (!queue.isEmpty()) {
                int node = queue.poll();
                visitedCount++;
                sum += nums[node];
                for (int neighbor : graph[node]) {
                    if ((mask & (1 << neighbor)) != 0
                            && !visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
            int selectedCount = Integer.bitCount(mask);
            if (visitedCount == selectedCount && sum % 2 == 0) {
                answer++;
            }
        }
        return answer;
    }
}
