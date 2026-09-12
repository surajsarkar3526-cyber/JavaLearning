package SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Arrays Element : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int[] result = SortArray(arr);

        for(int ele : result){
            System.out.print(ele+" ");
        }
    }

    private static int[] SortArray(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++){
            int j=i;
            while(j>0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        return arr;
    }
}