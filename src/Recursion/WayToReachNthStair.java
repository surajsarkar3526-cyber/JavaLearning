package Recursion;

import java.util.Scanner;

public class WayToReachNthStair {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        int n = sc.nextInt();

        System.out.print("The Total number of ways is : "+ways(n));

    }

    private static int ways(int n) {
        if(n==0 || n==1){
            return 1;
        }

        return ways(n-1) + ways(n-2);
    }
}