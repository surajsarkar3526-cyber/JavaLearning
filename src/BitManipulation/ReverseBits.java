package BitManipulation;

import java.util.Scanner;

public class ReverseBits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int n = sc.nextInt();
        System.out.println("Reversed Bits : " + reverseBits(n));
    }

    private static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            result = (result << 1) | bit;
            n = n >>> 1;
        }
        return result;
    }
}
