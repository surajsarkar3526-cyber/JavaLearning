package BitManipulation;

import java.util.Scanner;

public class MinimumBitToNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Start Number : ");
        int first = sc.nextInt();

        System.out.print("Enter Goal : ");
        int goal = sc.nextInt();

        System.out.println("Minimum Bit Flips : " + minBitFlips(first, goal));
    }

    private static int minBitFlips(int first, int goal) {

        int xor = first ^ goal;
        int count = 0;

        while (xor != 0) {
            count += xor & 1;
            xor = xor >> 1;
        }

        return count;
    }
}
