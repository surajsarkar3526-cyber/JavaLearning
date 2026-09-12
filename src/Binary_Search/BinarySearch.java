package Binary_Search;

import java.util.Scanner;

public class BinarySearch {
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
        boolean found = false;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] == target){
                System.out.println("Element found at index : " + mid);
                found = true;
                break;
            }
            else if(arr[mid] > target){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        if(!found){
            System.out.println("Element not found");
        }
    }
}