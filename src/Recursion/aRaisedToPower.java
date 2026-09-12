package Recursion;

import java.util.Scanner;

public class aRaisedToPower {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Base : ");
        long a = sc.nextInt();

        System.out.print("Enter Exponent : ");
        long b = sc.nextInt();

        System.out.print(Power(a, b));
    }
    private static long Power(long x, long y){

        if(y==0) return 1;
        long call = Power(x, y/2);

        if(y%2 == 0){
            return call*call;
        }
        else{
            return x*call*call;
        }
    }
}
