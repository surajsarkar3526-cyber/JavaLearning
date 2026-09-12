package DynamicProgramming;
import java.util.Arrays;
public class MinimumDeletionsPalindrome {
    public static void main(String[] args) {
        String s = "aebcbda";
        int n = s.length();

        String reverse = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[n+1][n+1];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        int lps = lcs(s, reverse, n, n, dp);
        int result = n - lps;
        System.out.println("Minimum Deletion : " + result);
    }

    private static int lcs(String s, String reverse, int i, int j, int[][] dp) {
        if(i==0 || j==0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i-1) == reverse.charAt(j-1)){
            dp[i][j] = 1 + lcs(s, reverse, i-1, j-1, dp);
        }
        else{
            dp[i][j] = Math.max(lcs(s, reverse,i-1, j, dp), lcs(s, reverse, i, j-1, dp));
        }

        return dp[i][j];
    }
}
