package Recursion;

import java.util.Scanner;

public class RecursionOnArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Array Size : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        for(int i = 0; i <= arr.length - 1; i++){
            arr[i] = sc.nextInt();
        }

        print(arr,0);
    }

    private static void print(int[] arr, int idx) {
        int n = arr.length;
        if(idx==n){
            return;
        }
        System.out.print(arr[idx] + " ");
        print(arr,idx+1);
    }
}
