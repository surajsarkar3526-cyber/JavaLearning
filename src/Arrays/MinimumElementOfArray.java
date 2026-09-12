package Arrays;

import java.util.Scanner;

public class MinimumElementOfArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int j=0; j<n; j++){
            System.out.print(arr[j] + " ");
        }
        System.out.print("\nThe Maximum inside Array is : ");
        int mElement = arr[0];
        int min = 0;
        for(int i=0; i<n; i++){
            if(arr[i] < mElement){
                mElement = arr[i];
            }
        }
        System.out.print(mElement);
    }
}
