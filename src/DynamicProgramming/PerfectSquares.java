package DynamicProgramming;

import java.util.Arrays;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 12;
        int answer = numSquares(n);
        System.out.println("Minimum perfect squares: " + answer);
    }

    private static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i],dp[i - square] + 1);
            }
        }

        return dp[n];
    }
}
