package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class NthFibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Fibonacci Number : ");
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println("Fibonacci Series : "+ fibonacci(n, dp));
    }

    private static int fibonacci(int n, int[] dp) {

        if(n == 1 || n==0){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = fibonacci(n -1, dp) + fibonacci(n - 2, dp);

        return dp[n];
    }
}
