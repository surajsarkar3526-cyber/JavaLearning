package DynamicProgramming;
import java.util.Arrays;
public class UniquePathsII {
    public static void main(String[] args) {

        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }

        return Solve(0,0,obstacleGrid,dp);
    }

    private static int Solve(int i, int j, int[][] obstacleGrid, int[][] dp) {

        if(obstacleGrid[i][j] == 1){
            return 0;
        }

        if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if(i + 1 < obstacleGrid.length){
            down = Solve(i+1, j, obstacleGrid, dp);
        }

        if(j+1 < obstacleGrid[0].length){
            right = Solve(i, j+1, obstacleGrid, dp);
        }

        dp[i][j] = down + right;
        return dp[i][j];
    }
}
