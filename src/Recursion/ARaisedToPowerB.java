package Recursion;

import java.util.Scanner;

public class ARaisedToPowerB {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Base : ");
        int a = sc.nextInt();

        System.out.print("Enter Exponent : ");
        int b = sc.nextInt();
        System.out.print(Power(a, b));
    }

    private static long Power(int a, int b) {
        if(b == 0){
            return 1;
        }
        return a * Power(a, b - 1);
    }
}
