package BitManipulation;

import java.util.Scanner;

public class XOROfNumbersInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter L: ");
        int L = sc.nextInt();

        System.out.print("Enter R: ");
        int R = sc.nextInt();

        System.out.println("XOR = " + xorRange(L, R));
    }

    private static int xorRange(int L, int R) {
        return xorUpto(R) ^ xorUpto(L - 1);
    }
    private static int xorUpto(int n) {

        if (n % 4 == 0) {
            return n;
        }
        else if (n % 4 == 1) {
            return 1;
        }
        else if (n % 4 == 2) {
            return n + 1;
        }
        else {
            return 0;
        }
    }
}
