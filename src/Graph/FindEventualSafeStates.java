package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        List<Integer> result;
        result = eventualSafeNodes(graph);
        System.out.println(result);
    }

    private static List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            for(int ele : graph[i]){
                adj.get(ele).add(i);
                indegree[i]++;
            }
        }

        // kahn's Algrithm's
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            for(int key : adj.get(node)){
                indegree[key]--;
                if(indegree[key] == 0){
                    queue.offer(key);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
