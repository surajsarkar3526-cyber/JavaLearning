package DynamicProgramming;
import java.util.Arrays;
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        int n = s.length();

        int[][] dp = new int[n][n];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        int result = lps(s, 0, n - 1, dp);
        System.out.println("Longest Palindromic Subsequence: " + result);

    }

    private static int lps(String s, int i, int j, int[][] dp) {
        if(i > j){
            return 0;
        }
        if(i == j){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = 2 + lps(s, i + 1, j - 1, dp);
        }
        else{
            dp[i][j] = Math.max(lps(s,i+1, j, dp), lps(s, i, j - 1, dp));
        }

        return dp[i][j];
    }
}
