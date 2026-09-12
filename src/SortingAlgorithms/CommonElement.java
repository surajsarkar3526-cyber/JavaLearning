package SortingAlgorithms;

import java.util.Scanner;

public class CommonElement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Size of Array : ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];

        System.out.print("Enter First Array of Element : ");
        for(int i=0; i<arr1.length; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter Second Size of Array : ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];

        System.out.print("Enter Second Array of Element : ");
        for(int i=0; i<arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.print("\nCommon Element of Array : ");
        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                if(arr1[i]==arr2[j]){
                    System.out.print(arr1[i]+" ");
                    break;
                }
            }
        }
    }
}