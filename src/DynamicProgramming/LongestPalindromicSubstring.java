package DynamicProgramming;

public class LongestPalindromicSubstring {

    static Boolean[][] dp;
    static int start = 0;
    static int maxLength = 1;

    static boolean solve(String s, int i, int j) {
        if (i == j) {
            return true;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (j == i + 1) {
            dp[i][j] = (s.charAt(i) == s.charAt(j));
            if (dp[i][j] && 2 > maxLength) {
                maxLength = 2;
                start = i;
            }
            return dp[i][j];
        }
        if (s.charAt(i) != s.charAt(j)) {
            dp[i][j] = false;
            return false;
        }
        dp[i][j] = solve(s, i + 1, j - 1);
        if (dp[i][j]) {
            int length = j - i + 1;
            if (length > maxLength) {
                maxLength = length;
                start = i;
            }
        }
        return dp[i][j];
    }
    public static void main(String[] args) {
        String s = "abacac";
        int n = s.length();
        dp = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            solve(s, i, n - 1);
        }

        System.out.println(s.substring(start, start + maxLength));
    }
}
