package Recursion;

import java.util.Scanner;

public class SumOfNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number : ");
        long n = sc.nextInt();

        System.out.print(Sum(n));
    }

    private static long Sum(long n) {

        if(n == 0){
            return 0;
        }

        return n + Sum(n-1);
    }
}
