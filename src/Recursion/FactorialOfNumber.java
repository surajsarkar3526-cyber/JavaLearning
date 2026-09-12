package Recursion;

import java.util.Scanner;

public class FactorialOfNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Factorial of a number : ");
        int n = sc.nextInt();

        int result = Factorial(n);
        System.out.print(result);
    }

    private static int Factorial(int n) {
        if(n==0 || n==1){
            return 1;
        }
        return n*Factorial(n-1);
    }
}
