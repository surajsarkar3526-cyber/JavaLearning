package DynamicProgramming;
import java.util.Arrays;
public class MinimumInsertionPalindrome {
    public static void main(String[] args) {
        String s = "mbadm";
        int n = s.length();

        int[][] dp = new int[n][n];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        int result = minInsertions(s, 0, n - 1, dp);
        System.out.println("Minimum Insertion : " + result);
    }

    private static int minInsertions(String s, int i, int j, int[][] dp) {
        if(i >= j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = minInsertions(s, i+1, j-1, dp);
        }
        else{
            int insertLeft = minInsertions(s, i+1, j, dp);
            int insertRight = minInsertions(s,i,j-1,dp);

            dp[i][j] = 1 + Math.max(insertLeft, insertRight);
        }

        return dp[i][j];
    }
}
