package Binary_Search;

import java.util.Scanner;

public class KthSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Sorted Positive Array Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter K: ");
        int k = sc.nextInt();
        int ans = findKthPositive(arr, k);
        System.out.println("Kth Missing Positive Number = " + ans);
        sc.close();
    }
    private static int findKthPositive(int[] arr, int k) {
        int current = 1;
        int i = 0;

        while (k > 0) {
            if (i < arr.length && arr[i] == current) {
                i++;
            }
            else {
                k--;
                if (k == 0) {
                    return current;
                }
            }
            current++;
        }
        return -1;
    }
}
