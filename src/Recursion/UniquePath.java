package Recursion;

import java.util.Scanner;

public class UniquePath {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Row Number : ");
        int n = sc.nextInt();

        System.out.print("Enter Column Number : ");
        int m = sc.nextInt();

        System.out.print("No. Of Unique Path Is : "+Uniquepath(0,0,n,m));
    }

    private static int Uniquepath(int i, int j, int n, int m) {

        if(i == m-1 && j == n-1){
            return 1;
        }

        if(i >= m || j >= m){
            return 0;
        }

        return Uniquepath(i+1,j,n,m) + Uniquepath(i,j+1,n,m);
    }
}
