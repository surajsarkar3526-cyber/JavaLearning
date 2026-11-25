package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PathwithMaximumProbability {
    static class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {1, 2},
                {0, 2}
        };
        int n = 3;
        int start = 0;
        int end = 2;
        double[] succProb = {0.5, 0.5, 0.2};
        System.out.println(maxProbability(n, edges, succProb, start, end));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        double[] dict = new double[n];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }
        //dict[start] = 1.0;
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        queue.offer(new Pair(start, 1.0));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            double currentDistance = current.prob;
            if (node == end) {
                return currentDistance;
            }
            if (currentDistance < dict[node]) {
                continue;
            }
            for (Pair p : graph.get(node)) {
                double totalTime = current.prob * p.prob;
                if (totalTime > dict[p.node]) {
                    dict[p.node] = totalTime;
                    queue.add(new Pair(p.node, totalTime));
                }
            }
        }
        return 0.0;
    }
}
