package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class FactorialMemoization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Fibonacci Number : ");
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println("Factorial of " + n + " = " + factorial(n, dp));
    }

    private static int factorial(int n, int[] dp) {

        if(n == 0 || n == 1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = n * factorial(n - 1, dp);
        return dp[n];
    }
}
