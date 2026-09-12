package DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;

public class WaysToReachNthStair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter K : ");
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(countWays(n, dp));
    }

    private static int countWays(int n, int[] dp) {
        if(n == 0){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        int ways1 = countWays(n - 1, dp);
        int ways2 = countWays(n - 2, dp);
        dp[n] = ways1 + ways2;

        return dp[n];
    }
}
