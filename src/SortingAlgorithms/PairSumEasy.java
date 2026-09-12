package SortingAlgorithms;

import java.util.Scanner;

public class PairSumEasy {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Array Element : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter Target : ");
        int target = sc.nextInt();
        int i = 0;
        int j = n-1;
        boolean found = false;
        while(i<j){
            if(arr[i] + arr[j] == target){
                System.out.print("pair Found : "+arr[i] +" + "+arr[j]+" = "+target);
                found = true;
                break;
            }
            else if(arr[i] + arr[j] > target){
                j--;
            }
            else{
                i++;
            }
            if(found){
                break;
            }
        }
        if(!found){
            System.out.print("\nPair not Found");
        }
    }
}
