package MergeSort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class InversionSort {
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        long count = mergeSort(arr);

        System.out.println("Inversion Is : " + count);
        System.out.println("Array In sorted Form : "+ Arrays.toString(arr));
    }

    private static long mergeSort(int[] arr) {

        int n = arr.length;

        if(n <= 1){
            return 0;
        }

        int[] left = new int[n/2];
        int[] right = new int[n-n/2];

        int idx = 0;
        for(int i=0; i < left.length; i++){
            left[i] = arr[idx++];
        }

        for(int i=0; i < right.length; i++){
            right[i] = arr[idx++];
        }

        long count = 0;

        count += mergeSort(left);
        count += mergeSort(right);
        count += mergeSorted(left,right,arr);

        return count;
    }

    private static long mergeSorted(int[] left, int[] right, int[] arr) {

        int i = 0;
        int j = 0;
        int k = 0;

        long count = 0;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
                count += left.length - i;
            }
        }

        while(i < left.length){
            arr[k++] = left[i++];
        }

        while(j < right.length){
            arr[k++] = right[j++];
        }
        return count;
    }
}
