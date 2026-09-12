package Binary_Search;

import java.util.Scanner;

public class FloorInSortedArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Arrays Element : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter Target : ");
        int target = sc.nextInt();

        int floor = FindFloor(arr,target);
        if(floor == -1){
            System.out.println("Floor does not exist");
        }
        else{
            System.out.println("Floor Value = " + arr[floor]);
            System.out.println("Floor Index = " + floor);
        }

    }

    private static int FindFloor(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int ans = -1;

        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                ans = mid;
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return ans;
    }
}