package Recursion;

import java.util.Scanner;

public class FindArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<= arr.length-1; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter your Target : ");
        int target = sc.nextInt();

        System.out.print("Target : "+findTarget(arr,0,target));
    }

    private static boolean findTarget(int[] arr, int i, int target) {
        if(i == arr.length){
            return false;
        }
        if (arr[i] == target ){
            return true;
        }
        return findTarget(arr,i+1,target);
    }
}