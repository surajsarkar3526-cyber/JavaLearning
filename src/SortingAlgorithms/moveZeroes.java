package SortingAlgorithms;

import java.util.Scanner;

public class moveZeroes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        sortZeroes(arr);
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }

    private static void sortZeroes(int[] arr) {

        int j = 0;
        int n = arr.length;

        for(int i=0; i<n; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}