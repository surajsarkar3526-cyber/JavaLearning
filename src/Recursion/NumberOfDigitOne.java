package Recursion;

public class NumberOfDigitOne {
    public static int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        return solve(n, 1);
    }
    public static int solve(int n, int factor) {
        if (factor > n) {
            return 0;
        }
        long lower = n % factor;
        long current = (n / factor) % 10;
        long higher = n / (factor * 10);
        long count;
        if (current == 0) {
            count = higher * factor;
        }
        else if (current == 1) {
            count = higher * factor + lower + 1;
        }
        else {
            count = (higher + 1) * factor;
        }
        return (int) count + solve(n, factor * 10);
    }
    public static void main(String[] args) {
        int n = 13;
        int answer = countDigitOne(n);
        System.out.println("Number of digit 1: " + answer);
    }
}
