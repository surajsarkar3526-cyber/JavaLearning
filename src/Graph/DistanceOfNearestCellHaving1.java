package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {
    static class Pair{
        int Row;
        int Col;
        int dist;
        Pair(int Row, int Col, int dist){
            this.Row = Row;
            this.Col = Col;
            this.dist = dist;
        }
    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };

        int[][] result = nearest(grid);
        for(int[] ele : result){
            for(int num : ele){
                System.out.print(num + " ");
            }
        }
    }

    public static int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    queue.offer(
                            new Pair(i, j,0)
                    );
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){

            Pair current = queue.remove();
            int row = current.Row;
            int col = current.Col;
            int dist = current.dist;
            distance[row][col] = dist;
            for(int k=0; k<4; k++){
                int newRow = row + dr[k];
                int newCol = col + dc[k];
                if(newRow >= 0 && newRow < n &&
                        newCol >= 0 && newCol < m &&
                        !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    queue.offer(
                            new Pair(newRow, newCol, dist+1)
                    );
                }
            }
        }
        return distance;
    }
}
