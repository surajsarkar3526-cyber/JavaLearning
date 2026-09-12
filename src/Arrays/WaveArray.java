package Arrays;

import java.util.Scanner;

public class WaveArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int m = arr.length;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        wave(arr);
        for(int i=0; i<n; i++){
            System.out.print(arr[i] +" ");
        }
    }

    public static void wave(int[] arr) {
        int n = arr.length - 1;
        for(int i=0; i<arr.length; i+=2){
            if(i>0 && arr[i] < arr[i-1]){
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
            if(i<n && arr[i] < arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }
}
