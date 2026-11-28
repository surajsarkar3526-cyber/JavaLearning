package Graph;

import java.util.PriorityQueue;

public class minimumCostToConnectAllPoints {
    public static class Triplet implements Comparable<Triplet>{
        int node;
        int parent;
        int dist;;
        Triplet(int node, int parent, int dist){
            this.node = node;
            this.parent = parent;
            this.dist = dist;
        }
        public int compareTo(Triplet T){
            if(this.dist == T.dist){
                return Integer.compare(this.node, T.node);
            }
            return Integer.compare(this.dist, T.dist);
        }
    }
    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };
        System.out.println(minCostConnectPoints(points));
    }

    private static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Triplet> queue = new PriorityQueue();
        queue.offer(new Triplet(0,-1,0));
        int sum = 0;
        boolean[] visited = new boolean[n];
        visited[0] = false;
        while(!queue.isEmpty()){
            Triplet current = queue.remove();
            int node = current.node, parent = current.parent, dist = current.dist;
            if(visited[node]) continue;
            sum += dist;
            visited[node] = true;
            for(int i=0; i<n; i++){
                int x = Math.abs(points[node][0] - points[i][0]);
                int y = Math.abs(points[node][1] - points[i][1]);
                int mds = x + y;
                if(i == node || visited[i]) continue;
                queue.offer(new Triplet(i, node, mds));
            }
        }
        return sum;
    }
}
