package Binary_Search;

import java.util.Scanner;

public class PeakInMountainArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Array Elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter Target : ");
        int target = sc.nextInt();
        int peak = findPeak(arr);
        System.out.println("Peak Index is : " + peak);
        System.out.println("Peak Element is : " + arr[peak]);
        int ans = binarySearchAsc(arr, target, 0, peak);
        if (ans == -1) {
            ans = binarySearchDesc(arr, target, peak + 1, n - 1);
        }
        System.out.println("Target Index is : " + ans);
    }
    private static int findPeak(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo+(hi-lo) / 2;
            if (arr[mid] < arr[mid + 1]) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }
    private static int binarySearchAsc(int[] arr, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return -1;
    }
    private static int binarySearchDesc(int[] arr, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] < target) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}