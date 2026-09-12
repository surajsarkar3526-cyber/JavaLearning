package Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. Of Disk : ");
        int disk = sc.nextInt();

        Hanoi(disk,'A','B','C');
        sc.close();
    }

    private static void Hanoi(int n, char a, char b, char c) {

        if(n==1){
            System.out.println("Move disk 1& from "+a+" to "+c);
            return;
        }

        Hanoi(n-1,a,c,b);
        System.out.print("Move disk "+ n +" from "+a+" to "+c);
        Hanoi(n-1,b,a,c);
    }
}
