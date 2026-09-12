package Arrays;

import java.util.Scanner;

public class SegregateArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int k = 0;
        int j = arr.length-1;
        while(k<j){
            if(arr[k] == 0 && k<j){
                k++;
            }
            if(arr[j] == 1 && k<j){
                j--;
            }
            int temp = arr[k];
            arr[k] = arr[j];
            arr[j] = temp;
            k++;
            j--;
        }
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }
}
