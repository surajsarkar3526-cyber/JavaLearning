package Arrays;
import java.util.*;
public class RotateArrayLeft {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
    public static void rotate(int[] arr, int k){
        int n = arr.length;
        int d = k / n;
        reverse(arr, 0, d-1);
        reverse(arr,d, n-1);
        reverse(arr, 0, n-1);
    }
    public static void reverse(int[] arr, int left, int right){
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
