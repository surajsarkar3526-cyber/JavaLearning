package DynamicProgramming;
import java.util.Arrays;
public class EditDistance {
    public static void main(String[] args) {
        String s1 = "geek";
        String s2 = "gesek";
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = editDistance(s1, s2, 0, 0, dp);
        System.out.println("Minimum Operations: " + result);
    }

    private static int editDistance(String s1, String s2, int i, int j, int[][] dp) {
        if(i == s1.length()){
            return s2.length() - j;
        }
        if(j == s2.length()){
            return s1.length() - i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = editDistance(s1, s2, i+1, j+1,dp);
        }
        else{
            int insert = editDistance(s1, s2, i, j+1, dp);
            int delete = editDistance(s1, s2, i+1, j, dp);
            int replace = editDistance(s1, s2, i+1, j+1, dp);

            dp[i][j] = 1+Math.min(insert, Math.min(delete, replace));
        }
        return dp[i][j];
    }
}
