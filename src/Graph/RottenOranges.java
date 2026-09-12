package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        int[][] mat = {
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };
        System.out.println(orangesRotting(mat));
    }

    private static int orangesRotting(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 2){
                    queue.offer(
                            new Pair(i, j)
                    );
                }
                if(mat[i][j] == 1){
                    fresh++;
                }
            }
        }
        int time = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Pair current = queue.remove();
                int r = current.row;
                int c = current.col;
                for(int k=0; k<4; k++){
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if(nr >= 0 && nr < n &&
                            nc >= 0 && nc < m &&
                            mat[nr][nc] == 1){
                        mat[nr][nc] = 2;
                        fresh--;
                        queue.offer(new Pair(nr, nc));
                    }
                }
            }
            time++;
        }
        if(fresh > 0){
            return -1;
        }
        return time;
    }
}
