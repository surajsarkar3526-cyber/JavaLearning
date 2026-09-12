package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class UnionOfArrays {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Size : ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        System.out.print("Enter First Arrays Element : ");
        for(int i=0; i<arr1.length; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.print("\nEnter a Size : ");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        System.out.print("\nEnter Second Arrays Element : ");
        for(int i=0; i<arr2.length; i++){
            arr2[i] = sc.nextInt();
        }
        ArrayList<Integer> result = unionofarrays(arr1, arr2);

        System.out.print("Union of Array is : ");
        for(int ele : result){
            System.out.print(ele+" ");
        }
    }

    private static ArrayList<Integer> unionofarrays(int[] arr1, int[] arr2) {
        int j = 0, i=0;

        ArrayList<Integer> union = new ArrayList<>();
        while(i<arr1.length && j<arr2.length){

            if(arr1[i] <= arr2[j]){

                if(union.size() == 0 ||
                union.get(union.size() - 1) != arr1[i]){
                    union.add(arr1[i]);
                }
                i++;
            }
            else{

                if(union.size() == 0 ||
                union.get(union.size()-1) != arr2[j]){
                    union.add(arr2[j]);
                }
                j++;
            }
        }
        while(i<arr1.length){
            if(union.size() == 0 ||
                    union.get(union.size() - 1) != arr1[i]){
                union.add(arr1[i]);
            }
            i++;
        }
        while(j<arr2.length){
            if(union.size() == 0 ||
                    union.get(union.size()-1) != arr2[j]){
                union.add(arr2[j]);
            }
            j++;
        }
        return union;
    }
}