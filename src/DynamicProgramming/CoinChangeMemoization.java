package DynamicProgramming;
import java.util.Arrays;
public class CoinChangeMemoization {
    public static void main(String[] args) {
        int[] coins = {9, 6, 5, 1};
        int sum = 19;

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);

        int result = minCoins(coins, sum, dp);
        System.out.println("Minimum Coins : " + result);
    }

    private static int minCoins(int[] coins, int sum, int[] dp) {
        if(sum == 0){
            return 0;
        }
        if(dp[sum] != -1){
            return dp[sum];
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            if(coin <= sum){
                int result = minCoins(coins, sum-coin, dp);
                if(result != Integer.MAX_VALUE){
                    min = Math.min(min, 1 + result);
                }
            }
        }
        dp[sum] = min;
        return dp[sum];
    }
}
