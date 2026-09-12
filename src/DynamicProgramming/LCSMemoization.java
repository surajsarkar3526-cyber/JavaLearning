package DynamicProgramming;
import java.util.Arrays;
public class LCSMemoization {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] ele : dp){
            Arrays.fill(ele,-1);
        }
        int result = lcs(text1, text2, 0, 0, dp);
        System.out.println("LCS length : " + result);
    }

    private static int lcs(String text1, String text2, int i, int j, int[][] dp) {
        if(i==text1.length() || j ==text2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] = 1+lcs(text1, text2, i+1, j+1, dp);
        }
        else{
            dp[i][j] = Math.max(lcs(text1, text2, i+1, j, dp), lcs(text1, text2, i, j+1, dp));
        }

        return dp[i][j];
    }
}
