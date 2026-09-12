package Recursion;

import java.util.Scanner;

public class ReverseOfNumber {
    private static void Power(long x, long r){

        if(x==0){
            System.out.println(r);
            return;
        }
        Power(x/10, r*10 + (x%10));
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        long a = sc.nextInt();

        long b = 0;
        Power(a, b);
    }
}
