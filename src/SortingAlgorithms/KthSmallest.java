package SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size of Array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter Array Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        if (k <= 0 || k > n) {
            System.out.println("Invalid value of k");
            return;
        }

        Arrays.sort(arr);

        System.out.println("Kth Smallest Element = " + arr[k - 1]);
    }
}