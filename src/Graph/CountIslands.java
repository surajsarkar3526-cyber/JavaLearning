package Graph;

public class CountIslands {
    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) {
        char[][] grid = {
                {'L', 'L', 'W', 'W', 'W'},
                {'W', 'L', 'W', 'W', 'L'},
                {'L', 'W', 'W', 'L', 'L'},
                {'W', 'W', 'W', 'W', 'W'},
                {'L', 'W', 'L', 'L', 'W'}
        };

        int result = countIslands(grid);
        System.out.println(result);
    }

    private static int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 'L' && !visited[i][j]){
                    count++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }
    private static void dfs(int row, int col, char[][] grid, boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = true;
        for(int i=0; i<8; i++){
            int newRow = row + dr[i];
            int newCol = col + dc[i];
            if(newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m){
                if(grid[newRow][newCol] == 'L' &&
                        !visited[newRow][newCol]){
                    dfs(newRow, newCol, grid, visited);
                }
            }
        }
    }
}
