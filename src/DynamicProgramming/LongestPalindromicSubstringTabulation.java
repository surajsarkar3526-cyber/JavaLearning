package DynamicProgramming;

public class LongestPalindromicSubstringTabulation {
    public static void main(String[] args) {
        String s = "abacac";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i + length <= n; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (length == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && length > maxLength) {
                    maxLength = length;
                    start = i;
                }
            }
        }
        System.out.println(s.substring(start, start + maxLength));
    }
}
