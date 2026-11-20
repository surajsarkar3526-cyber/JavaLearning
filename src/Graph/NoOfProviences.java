package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfProviences {
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int result = findCircleNum(isConnected);
        System.out.println(result);
    }
    public static int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int province = 0;
        for(int i=0; i<isConnected.length; i++){
            if(!visited[i]){
                province++;
                bfs(isConnected,visited,i);
            }
        }
        return province;
    }

    private static void bfs(int[][] isConnected, boolean[] visited, int i) {
        queue.add(i);
        visited[i] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int j=0; j< isConnected.length; j++){
                if(isConnected[node][j] == 1 && !visited[j]){
                    visited[j] = true;
                    bfs(isConnected,visited,j);
                }
            }
        }
    }
}
