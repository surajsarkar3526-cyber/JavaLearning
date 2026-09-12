package SortingAlgorithms;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size Of Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Array Element : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean isSorted = true;
            for (int k = 0; k < n - 1; k++) {
                if (arr[k] > arr[k + 1]) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted) break;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                }
            }
        }
        System.out.print("Sorted Array ");
        if (count != 0) {
            for (int ele : arr) {
                System.out.print(ele + " ");
            }
        }
    }
}