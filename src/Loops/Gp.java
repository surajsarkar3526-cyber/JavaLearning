package Loops;

import java.util.Scanner;

public class Gp {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the terms of number : ");
        int n = sc.nextInt();
        System.out.print("Enter 1st term : ");
        int a = sc.nextInt();
//        System.out.print("Enter Gemotric Progression : ");
//        int r = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            a *= 2;
        }
    }
}
