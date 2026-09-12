package DynamicProgramming;

public class CountDerangement {
    public static void main(String[] args) {

        int n = 4;

        int result = countDerangement(n);

        System.out.println("Number of Derangements: " + result);
    }

    private static int countDerangement(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 0;

        for(int i = 2; i<=n; i++){
            dp[i] = (i-1)*(dp[n-1] + dp[n-2]);
        }
        return dp[n];
    }
}
