package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindIfPathIsExist {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        int source = 0;
        int destination = 2;
        System.out.println(validPath(n,edges,source,destination));
    }
    static Queue<Integer> queue = new ArrayDeque<>();
    private static boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination){
            return true;
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<edges.length; i++){
            result.add(new ArrayList<>());
        }
        for(int j=0; j<edges.length; j++){
            int a = edges[j][0];
            int b = edges[j][1];
            result.get(a).add(b);
            result.get(b).add(a);
        }
        bfs(result,source,destination,visited);
        return visited[destination];
    }
    private static void bfs(List<List<Integer>> edges, int source, int destination,boolean[] visited){
        visited[source] = true;
        queue.add(source);
        while(!queue.isEmpty()){
            int node = queue.remove();
            for(int num : edges.get(node)){
                if(!visited[num]){
                    visited[num] = true;
                    queue.add(num);
                    if(num == destination){
                        return;
                    }
                }
            }
        }
    }
}
