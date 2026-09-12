package Graph;

public class NumberOfEnclaves {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        System.out.println(numEnclaves(grid));
    }

    private static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<m; i++){
            if(grid[0][i] == 1){
                dfs(grid, 0, i);
            }
            if(grid[n-1][i] == 1){
                dfs(grid, n-1, i);
            }
        }
        for(int i=0; i<n; i++){
            if(grid[i][0] == 1){
                dfs(grid, i, 0);
            }
            if(grid[i][m-1] == 1){
                dfs(grid, i, m-1);
            }
        }
        int count = 0;
        for(int k=0; k<n; k++){
            for(int d=0; d<m; d++){
                if(grid[k][d] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(int[][] grid, int row, int col){
        int n = grid.length;
        int m = grid[0].length;
        if(row < 0 || row >= n ||
                col < 0 || col >= m ||
                grid[row][col] == 0
        ){
            return;
        }
        grid[row][col] = 0;
        for(int i=0; i<4; i++){
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            dfs(grid,newRow, newCol);
        }
    }
}
