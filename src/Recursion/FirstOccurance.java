package Recursion;

import java.util.Scanner;

public class FirstOccurance {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<=arr.length-1; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter Target : ");
        int target = sc.nextInt();

        int result = FirstOccuanc(arr,0,arr.length-1,target);
        if(result != -1){
            System.out.println("First Occurance Index Is : "+result+"\n"+"Element at Index : "+arr[result]);
        }
        else{
            System.out.print("FirstOccurance Has Not Found");
        }
    }

    private static int FirstOccuanc(int[] arr, int lo, int hi, int target) {
        if(lo > hi){
            return -1;
        }

        int ans = -1;
        int mid = lo + (hi - lo)/2;

        if(arr[mid] == target){
            ans = mid;
            hi = mid - 1;
            return ans;
        }

        if(arr[mid] > target){
            return FirstOccuanc(arr,lo,mid-1,target);
        }
        return FirstOccuanc(arr,mid+1,hi,target);
    }
}
