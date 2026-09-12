package Binary_Search;

import java.util.Scanner;

public class FirstOccurance {
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
        int lo = 0;
        int hi = n - 1;
        int ans = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] == target){
               ans = mid;
               hi = mid-1;
            }
            else if(arr[mid] > target){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        System.out.print("My First Occurance is : " + ans);
    }
}