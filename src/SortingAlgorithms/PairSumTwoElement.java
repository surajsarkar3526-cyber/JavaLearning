package SortingAlgorithms;

import java.util.Scanner;

public class PairSumTwoElement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Array Element : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter a Target Element : ");
        int target = sc.nextInt();

        boolean found = false;
        for(int i=0; i<n-1; i++){
            for(int j =i+1; j<n; j++){
                if(arr[i] + arr[j] == target){
                    System.out.print("Pair Found : " + arr[i] +" + "+arr[j]);
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }
        if(!found){
            System.out.print("Pair Not Found ");
        }
    }
}