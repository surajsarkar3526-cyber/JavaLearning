package DynamicProgramming;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s1 = "aa";
        String p1 = "a";
        System.out.println(isMatch(s1, p1));
        String s2 = "aa";
        String p2 = "a*";
        System.out.println(isMatch(s2, p2));
        String s3 = "ab";
        String p3 = ".*";
        System.out.println(isMatch(s3, p3));
    }
    private static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int j=2; j<=m; j++){
            if(p.charAt(j-1)=='*'){
                dp[0][j] = dp[0][j-2];
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                char currentString = s.charAt(i-1);
                char currentPattern = p.charAt(j-1);
                if(currentString == currentPattern || currentPattern == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if (currentPattern == '*') {
                    dp[i][j] = dp[i][j - 2];
                    char previousPattern = p.charAt(j - 2);
                    if (previousPattern == currentString || previousPattern == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
