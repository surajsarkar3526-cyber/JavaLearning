package DynamicProgramming;
import java.util.Arrays;
public class NumberOfPaths {
    public static void main(String[] args) {

        int m = 3;
        int n = 3;

        int[][] dp = new int[3][3];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        System.out.println(countPaths(0, 0, m, n, dp));
    }

    private static int countPaths(int i, int j, int m, int n, int[][] dp) {
        if(i == m -1 && j == n-1){
            return 1;
        }
        if(i >= m || j >= n){
            return 0;
        }

        int down = countPaths(i + 1,j,m,n,dp);
        int right = countPaths(i, j+1, m, n, dp);
        dp[i][j] = down + right;

        return dp[i][j];
    }
}
