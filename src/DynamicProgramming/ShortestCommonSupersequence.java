package DynamicProgramming;
import java.util.Arrays;
public class ShortestCommonSupersequence {
    public static void main(String[] args) {

        String s1 = "abac";
        String s2 = "cab";

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int result = scs(s1, s2, 0, 0, dp);

        System.out.println("Shortest Common Supersequence Length: " + result);
    }

    private static int scs(String s1, String s2, int i, int j, int[][] dp) {
        if(i==s1.length()){
            return s2.length() - j;
        }
        if(j==s2.length()){
            return s1.length() - i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1+scs(s1, s2, i+1, j+1, dp);
        }
        else{
            int insert = scs(s1, s2, i+1, j, dp);
            int delete = scs(s1, s2, i, j+1, dp);

            dp[i][j] = 1+Math.min(insert, delete);
        }

        return dp[i][j];
    }
}
