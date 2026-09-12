package Arrays;

import java.util.Scanner;

public class ProductOfArray {
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
        System.out.print("\nThe product of Array is ");
        int sum = 1;
        for(int i=0; i<n; i++){
            sum *= arr[i];
        }
        System.out.print("\n" + sum);
    }
}
