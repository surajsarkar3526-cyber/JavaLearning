package Arrays;

import java.util.Scanner;

public class SumOfArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for(int i=0; i<6; i++){
            arr[i] = sc.nextInt();
        }
        for(int j=0; j<6; j++){
            System.out.print(arr[j] + " ");
        }
        System.out.print("\nThe Sum of Array is ");
        int sum = 0;
        for(int i=0; i<6; i++){
            sum += arr[i];
        }
        System.out.print("\n" + sum);
    }
}
