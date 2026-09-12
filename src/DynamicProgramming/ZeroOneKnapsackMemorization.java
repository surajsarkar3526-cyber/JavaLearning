package DynamicProgramming;

import java.util.Scanner;

public class ZeroOneKnapsackMemorization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Size of Weight : ");
        int wt = sc.nextInt();

        int[] weight = new int[wt];
        System.out.println("Input the Elements => ");
        for (int i = 0; i < wt; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.print("Input Size of Value : ");
        int val = sc.nextInt();

        int[] value = new int[val];
        System.out.println("Input the Values Elements => ");
        for (int i = 0; i < val; i++) {
            value[i] = sc.nextInt();
        }
        System.out.print("Input the Capacity : ");
        int capacity = sc.nextInt();

        int answer = knapsack(weight, value, capacity);
        System.out.println("Maximum Value : " + answer);
    }

    private static int knapsack(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=capacity; j++){
                dp[i][j] = -1;
            }
        }

        return solve(weight, value, capacity, dp, n);
    }

    private static int solve(int[] weight, int[] value, int capacity, int[][] dp, int n) {
        if(n == 0 || capacity == 0){
            return 0;
        }
        if(dp[n][capacity] != -1){
            return dp[n][capacity];
        }
        if(weight[n - 1] > capacity){
            dp[n][capacity] = solve(weight, value, capacity, dp, n-1);
            return dp[n][capacity];
        }
        int take = value[n-1] + solve(weight, value, capacity-weight[n-1], dp, n-1);

        int nonTake = solve(weight, value, capacity, dp, n-1);
        dp[n][capacity] = Math.max(take, nonTake);
        return dp[n][capacity];
    }
}
