package DynamicProgramming;

public class MinCostClimbingStairsTabulation {
    public static void main(String[] args) {

        int[] cost = {10, 15, 20};
        int n = cost.length;

        int[] dp = new int[n + 2];

        dp[n] = 0;
        dp[n + 1] = 0;
        for(int i = n - 1; i>=0; i--){
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        int answer = Math.min(dp[0], dp[1]);

        System.out.println(answer);
    }
}
