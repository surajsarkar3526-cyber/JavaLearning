package Arrays;

import java.util.Scanner;

public class MergeTwoSortedArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Array of Size : ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.print("Enter Array of Element : ");
        for(int i=0; i<n1; i++){
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter Second size of Element : ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.print("Enter Second Array of Element : ");
        for(int j=0; j<n2; j++){
            arr2[j] = sc.nextInt();
        }
        int[] result = merge(arr1, arr2);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] ans = new int[n1 + n2];

        int i = 0;
        int j =  0;
        int k =0;

        while(i < n1 && j < n2){
            if(arr1[i] <= arr2[j]){
                ans[k] = arr1[i];
                i++;
            }
            else{
                ans[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            ans[k] = arr1[i];
            i++;
            k++;
        }
        while(j < n2) {
            ans[k] = arr2[j];
            j++;
            k++;
        }
        return ans;
    }
}
