package Graph;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0},
                {1, 0, 0},
                {0, 1, 1}
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    private static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    public static int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length ||
                grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        int area = 1;
        area += dfs(grid, row - 1, col);
        area += dfs(grid, row + 1, col);
        area += dfs(grid, row, col - 1);
        area += dfs(grid, row, col + 1);
        return area;
    }
}
