package Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite2 {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 2, 3},
                {0, 2},
                {0, 1, 3},
                {0, 2}
        };
        System.out.println(IsGraphBipartite(graph));
    }
    private static boolean IsGraphBipartite(int[][] graph){
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(color[i] == -1){
                queue.add(i);
                color[i] = 0;
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    for(int key : graph[node]){
                        if(color[key] == -1){
                            color[key] = 1 - color[node];
                            queue.add(key);
                        }
                        else if(color[key] == color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
