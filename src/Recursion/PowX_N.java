package Recursion;

import java.util.Scanner;

public class PowX_N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = 2;
        long n = 10;
        long answer = myPow(x, n);
        System.out.println(x + "^" + n + " = " + answer);
        sc.close();
    }

    private static long myPow(long x, long n) {
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        return power(x, n);
    }

    private static long power(long x, long n) {
        if(n==0){
            return 1;
        }
        long half = power(x, n/2);
        if(n % 2 == 0){
            return half * half;
        }
        return half*half*x;
    }
}
