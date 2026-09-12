package Recursion;

import java.util.Scanner;

public class GCDOfTwoNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Number : ");
        int a = sc.nextInt();

        System.out.print("Enter Second Number : ");
        int b = sc.nextInt();

        System.out.print("Greates Common Division (GCD) : "+GreaComDivision(a, b));
        sc.close();
    }

    private static int GreaComDivision(int a, int b) {

        if(b == 0){
            return a;
        }

        return GreaComDivision(b, a%b);
    }
}