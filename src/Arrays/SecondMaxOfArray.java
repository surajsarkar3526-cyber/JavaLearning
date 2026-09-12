package Arrays;

import java.util.Scanner;

public class SecondMaxOfArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Maximum Number is : "+max);

        int smax = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > smax && arr[i] != max){
                smax = arr[i];
            }
        }
        System.out.println("Second maximum number is : "+smax);
    }
}
