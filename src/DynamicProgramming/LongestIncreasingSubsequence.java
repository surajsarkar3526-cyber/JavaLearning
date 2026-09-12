package DynamicProgramming;
import java.util.Arrays;
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        int n = arr.length;

        int[][] dp = new int[n][n+1];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }

        int result = lcs(arr, 0, -1, dp);
        System.out.println("Maximum LCS : " + result);
    }

    private static int lcs(int[] arr, int i, int j, int[][] dp) {
        if(i == arr.length){
            return 0;
        }
        int dpIndex = j + 1;
        if(dp[i][dpIndex] != -1){
            return dp[i][dpIndex];
        }
        int nonTake = lcs(arr, i+1, j, dp);
        int take = 0;
        if(j == -1 || arr[i] > arr[j]){
            take = 1 + lcs(arr, i + 1, i, dp);
        }

        return dp[i][dpIndex] = Math.max(nonTake, take);
    }
}
