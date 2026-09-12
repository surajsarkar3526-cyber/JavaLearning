package Graph;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        int n = grid.length;
         int m = grid[0].length;
         int count = 0;
         for(int i=0; i<n; i++){
             for(int j=0; j<m; j++){
                 if(grid[i][j] == '1'){
                     count++;
                     dfs(grid, i, j);
                 }
             }
         }
         return count;
    }
    private static void dfs(char[][] grid, int row, int col){
        int n = grid.length;
        int m = grid[0].length;
        if(row < 0 || row >= n || col < 0 || col >= m){
            return;
        }
        if(grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col+1);
    }
}
