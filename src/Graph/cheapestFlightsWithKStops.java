package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;

public class cheapestFlightsWithKStops {
    public static void main(String[] args) {
        System.out.println();
    }
    public static class Pair{
        int node;
        int cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public static class Triplet{
        int node;
        int cost;
        int stops;
        Triplet(int node, int cost, int stops){
            this.node =node;
            this.cost = cost;
            this.stops = stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++){
            int a = flights[i][0];
            int b = flights[i][1];
            int c = flights[i][2];
            graph.get(a).add(new Pair(b,c));
        }
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        Queue<Triplet> queue = new LinkedList<>();
        queue.add(new Triplet(src,0,0));
        while(!queue.isEmpty()){
            Triplet current = queue.poll();
            int node = current.node;
            int cost = current.cost;
            int stops = current.stops;
            if(stops == k+1){
                continue;
            }
            for(Pair p : graph.get(node)){
                int totalCost = cost + p.cost;
                if(totalCost < ans[p.node]){
                    ans[p.node] = totalCost;
                    queue.add(new Triplet(p.node, totalCost, stops+1));
                }
            }
        }
        if(ans[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return ans[dst];
    }
}
