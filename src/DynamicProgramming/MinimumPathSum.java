package DynamicProgramming;
import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {

        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(minPathSum(grid));
    }

    private static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }

        return Solve(0,0,grid,dp);
    }

    private static int Solve(int i, int j, int[][] grid, int[][] dp) {

        if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if(i+1 < grid.length){
            down = Solve(i+1, j, grid, dp);
        }

        if(j+1 < grid[0].length){
            right = Solve(i, j+1, grid, dp);
        }

        dp[i][j] = grid[i][j] + Math.min(right, down);

        return dp[i][j];
    }
}
