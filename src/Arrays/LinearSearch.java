package Arrays;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int j=0; j<n; j++){
            arr[j] = sc.nextInt();
        }
        System.out.print("\nEnter your Number : ");
        int target = sc.nextInt();
        boolean flag = false;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                flag = true;
                break;
            }
        }
        if(!flag) System.out.print("Target Not Found");
        else System.out.print("Target Found");
    }
}
