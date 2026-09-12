package Binary_Search;

import java.util.Scanner;

public class SearchSortedAndRotatedArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Size of Array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter Array Elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter Target Element: ");
        int target = sc.nextInt();

        int index = search(arr, target);

        if (index == -1) {
            System.out.println("Element Not Found");
        }
        else {
            System.out.println("Element Found at Index: " + index);
        }

        sc.close();
    }

    public static int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[low] < arr[mid]) {
                if (target > arr[low]) {
                    if (target < arr[mid]) {
                        high = mid - 1;
                    }
                    else {
                        low = mid + 1;
                    }

                }
                else if (target == arr[low]) {
                    return low;
                }
                else {
                    low = mid + 1;
                }
            }
            else if (arr[low] == arr[mid]) {
                if (target == arr[low]) {
                    return low;
                }
                low++;
            }
            else {
                if (target > arr[mid]) {
                    if (target < arr[high]) {
                        low = mid + 1;
                    }
                    else if (target == arr[high]) {
                        return high;
                    }
                    else {
                        high = mid - 1;
                    }
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}