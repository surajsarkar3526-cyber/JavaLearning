package Recursion;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.print("Arrays Element are : ");

        for(int i=0; i<=arr.length-1; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter Target : ");
        int target = sc.nextInt();

        int result = BinaryTarget(arr,0,arr.length-1,target);

        if(result == -1){
            System.out.print("Target Not Found");
        }
        else{
            System.out.println("Target Of Element At Index : "+result);
            System.out.print("Array Element Is : "+arr[result]);
        }
    }

    private static int BinaryTarget(int[] arr, int lo, int hi, int target) {

        if(lo > hi){
            return -1;
        }

        int mid = lo + (hi - lo )/2;

        if(arr[mid] > target){
            return BinaryTarget(arr,lo,mid-1,target);
        }
        if(arr[mid] < target){
            return BinaryTarget(arr,mid+1,hi,target);

        }
        return mid;
    }
}
