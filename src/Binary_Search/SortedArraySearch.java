package Binary_Search;

import java.util.Scanner;

public class SortedArraySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Sorted Array Elements : ");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter Target : ");
        int target = sc.nextInt();
        int index = binarySearch(arr, target);
        if(index == -1) {
            System.out.println("Element Not Found");
        } else {
            System.out.println("Element Found at Index : " + index);
        }
    }
    private static int binarySearch(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}