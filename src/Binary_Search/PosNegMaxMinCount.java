package Binary_Search;

import java.util.Scanner;

public class PosNegMaxMinCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Arrays Element : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int pos = 0;
        int neg = 0;

        for (int num : arr) {

            if (num > 0) {
                pos++;
            }
            if (num < 0) {
                neg++;
            }
        }
        System.out.println("The Maximum Positive IS : " + pos);
        System.out.println("The Maximum Negative Is : " + neg);
        System.out.print("The Maximum Count Is : " + Math.max(pos, neg));
    }
}
