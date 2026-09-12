package MergeSort;

import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoSortedArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Array Size : ");
        int n = sc.nextInt();

        System.out.print("Enter Second Size of Array : ");
        int m = sc.nextInt();

        int[] arr1 = new int[n];
        for(int i=0; i<arr1.length; i++){
            arr1[i] = sc.nextInt();
        }

        int[] arr2 = new int[m];
        for(int i=0; i<arr2.length; i++){
            arr2[i] = sc.nextInt();
        }

        int[] result = new int[arr1.length + arr2.length];

        mergeSort(arr1,arr2,result,0,0,0);
        System.out.print(Arrays.toString(result));
    }

    private static void mergeSort(int[] arr1, int[] arr2, int[] result, int i, int j, int k) {

        if(i == arr1.length && j == arr2.length){
            return;
        }

        if(i==arr1.length){
            result[k] = arr2[j];
            mergeSort(arr1,arr2,result,i,j+1,k+1);
        }

        else if(j == arr2.length){
            result[k] = arr1[i];
            mergeSort(arr1,arr2,result,i+1,j,k+1);
        }

        else if(arr1[i] <= arr2[j]){
            result[k] = arr1[i];
            mergeSort(arr1,arr2,result,i+1,j,k+1);
        }

        else if(arr1[i] >= arr2[j]){
            result[k] = arr2[j];
            mergeSort(arr1,arr2,result,i,j+1,k+1);
        }
    }
}
