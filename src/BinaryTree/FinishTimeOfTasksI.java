package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class FinishTimeOfTasksI {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {
                {0, 1},
                {0, 2}
        };
        int[] baseTime = {4, 7, 6};
        long answer = finishTime(n, edges, baseTime);
        System.out.println("Finish time of root: " + answer);
    }

    private static long finishTime(int n, int[][] edges, int[] baseTime) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int parent = edge[0];
            int child = edge[1];
            graph.get(parent).add(child);
        }
        return dfs(0,graph,baseTime);
    }

    private static long dfs(int node, List<List<Integer>> graph, int[] baseTime) {
        if(graph.get(node).isEmpty()){
            return baseTime[node];
        }
        long earliest = Long.MAX_VALUE;
        long latest = Long.MIN_VALUE;
        for(int child : graph.get(node)){
            long childFinishTime = dfs(child, graph, baseTime);
            earliest = Math.min(earliest,childFinishTime);
            latest = Math.max(latest, childFinishTime);
        }
        long OwnDuration = (latest - earliest) + baseTime[node];
        return latest + OwnDuration;
    }
}
