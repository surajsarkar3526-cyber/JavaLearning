package DynamicProgramming;

import java.util.Arrays;

public class CoinChangeTabulation {
    public static void main(String[] args) {
        int[] coins = {9, 6, 5, 1};
        int sum = 19;

        int result = coinChange(coins, sum);
        System.out.println("Minimum Coins: " + result);
    }

    private static int coinChange(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, sum + 1);
        dp[0] = 0;
        for (int i = 1; i <= sum; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        if (dp[sum] == sum + 1) {
            return -1;
        }

        return dp[sum];
    }
}
