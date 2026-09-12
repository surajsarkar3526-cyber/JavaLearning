package BackTracking;
import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] =sc.nextInt();
        }
        permute(arr,0);

        sc.close();
    }

    private static void permute(int[] arr, int index) {
        if(index == arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=index; i<arr.length; i++){
            swap(arr, index, i);
            permute(arr, index + 1);
            swap(arr, index, i);
        }
    }
    private  static void swap(int[] arr, int j, int i){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println(Arrays.toString(arr));
    }
}
