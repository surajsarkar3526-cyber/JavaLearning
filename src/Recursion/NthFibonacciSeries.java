package Recursion;

import java.util.Scanner;

public class NthFibonacciSeries {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int n = sc.nextInt();

        System.out.print("Fibonacci Series is :  "+fibo(n));
    }

    private static int fibo(int n) {

        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }
}