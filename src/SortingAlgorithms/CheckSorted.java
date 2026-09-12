package SortingAlgorithms;

import java.util.Scanner;

public class CheckSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size Of Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Array Element : ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        boolean flag = true;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] > arr[j]){
                    flag = false;
                    break;
                }
            }
        }
        if(!flag){
            System.out.print("Unsorted Array ");
        }
        else{
            System.out.print("Sorted Array ");
        }
    }
}
