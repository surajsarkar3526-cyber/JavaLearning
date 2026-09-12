package Arrays;
import java.util.Arrays;
public class ReverseInGroups {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        reverseInGroup(arr,k);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseInGroup(int[] arr, int k) {
        for(int i=0; i<arr.length; i += k){
            int start = i;
            int end = Math.min(i+k-1, arr.length-1);
            while(start < end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }
}
