package Binary_Search;

import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastOccurance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Sorted Array Elements : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter Target : ");
        int target = sc.nextInt();

        int First = FirstOccurance(arr, target);
        int Last = LastOccurance(arr, target);

        System.out.println("My first Occurance is : "+ First);
        System.out.println("My Last Occurance is : "+ Last);
    }

    private static int LastOccurance(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int ans = -1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(arr[mid] == target){
                ans = mid;
                lo = mid + 1;
            }
            else if(arr[mid] < target){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return ans;
    }

    private static int FirstOccurance(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int ans = -1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(arr[mid] == target){
                ans = mid;
                hi = mid - 1;
            }
            else if(arr[mid] < target){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return ans;
    }
}