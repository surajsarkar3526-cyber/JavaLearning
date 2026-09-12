package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size : ");
        int n = sc.nextInt();

        int[] cost = new int[n];
        System.out.print("Enter Arrays Elements : ");
        for(int i=0; i<n; i++){
            cost[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int answer = Math.min(
                minCost(0, cost, dp),
                minCost(1, cost, dp)
        );

        System.out.println(answer);
    }

    private static int minCost(int i, int[] arr, int[] dp) {
        if(i >= arr.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int oneStep = minCost(i + 1, arr, dp);
        int twoStep = minCost(i + 2, arr, dp);

        dp[i] = arr[i] + Math.min(oneStep, twoStep);
        return dp[i];
    }
}
