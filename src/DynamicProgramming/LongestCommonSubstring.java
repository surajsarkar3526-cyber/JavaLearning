package DynamicProgramming;
import java.util.Arrays;
public class LongestCommonSubstring {
    static int[][] dp;
    static int solve(String s1, String s2, int i, int j){
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1 + solve(s1, s2, i+1, j+1);
        }
        else{
            dp[i][j] = 0;
        }
        return dp[i][j];
    }
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        int n = s1.length();
        int m = s2.length();
        dp = new int[n][m];
        for(int[] ele : dp){
            Arrays.fill(ele, -1);
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                answer = Math.max(answer, solve(s1, s2, i, j));
            }
        }
        System.out.println("Longest Common Substring Length = " + answer);
    }
}
