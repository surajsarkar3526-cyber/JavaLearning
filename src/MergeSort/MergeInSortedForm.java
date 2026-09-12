package MergeSort;

import java.util.Scanner;

public class MergeInSortedForm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        mergeSorted(arr);
        for(int ele : arr){
            System.out.print(ele+" ");
        }
    }

    private static void mergeSorted(int[] arr) {
        int n = arr.length;

        if(n==1){
            return;
        }
        int[] a = new int[n/2];
        int[] b = new int[n-n/2];

        int idx = 0;
        for(int i=0; i<a.length; i++){
            a[i] = arr[idx];
            idx++;
        }

        for(int j=0; j<b.length; j++){
            b[j] = arr[idx++];
        }

        mergeSorted(a);
        mergeSorted(b);

        merge(a,b,arr);
    }

    private static void merge(int[] a, int[] b, int[] arr) {

        int i=0, j=0, k=0;

        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                arr[k++] = a[i++];
            }

            else{
                arr[k++] = b[j++];
            }
        }
        while(i < a.length){
            arr[k++] = a[i++];
        }

        while(j < b.length){
            arr[k++] = b[j++];
        }
    }
}
