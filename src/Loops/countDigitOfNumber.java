package Loops;

import java.util.Scanner;

public class countDigitOfNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number : ");
        int n = sc.nextInt();

        int r = 0;

        while (n != 0) {
            r = r * 10;
            r = r + n % 10;
            n /= 10;
        }

        System.out.println("Reverse Number = " + r);
    }
}
