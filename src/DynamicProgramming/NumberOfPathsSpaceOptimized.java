package DynamicProgramming;
import java.util.Arrays;
public class NumberOfPathsSpaceOptimized {
    public static void main(String[] args) {

        int m = 3;
        int n = 3;

        System.out.println(numberOfPaths(m, n));
    }

    private static int numberOfPaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}
