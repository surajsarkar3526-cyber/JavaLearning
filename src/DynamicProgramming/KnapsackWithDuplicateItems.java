package DynamicProgramming;
import java.util.Arrays;
public class KnapsackWithDuplicateItems {
    public static void main(String[] args) {

        int[] val = {10, 40, 50, 70};
        int[] wt = {1, 3, 4, 5};

        int capacity = 8;

        int[][] dp = new int[val.length][capacity + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = knapSack(0, capacity, val, wt, dp);
        System.out.println("Maximum Profit: " + result);
    }

    private static int knapSack(int i, int capacity, int[] val, int[] wt, int[][] dp) {

        if(i == val.length){
            return 0;
        }
        if(dp[i][capacity] != -1){
            return dp[i][capacity];
        }

        int nonTake = knapSack(i+1, capacity, val, wt, dp);
        int take = 0;
        if(wt[i] <= capacity){
            take = val[i] + knapSack(i, capacity-wt[i], val, wt, dp);
        }

        dp[i][capacity] = Math.max(take,nonTake);
        return dp[i][capacity];
    }
}
