package Arrays;
import java.util.ArrayList;
public class FirstAndLast {
    public static void main(String[] args){
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int x = 5;
        ArrayList<Integer> result = firstAndLast(arr, x);
        System.out.print(result);
    }

    private static ArrayList<Integer> firstAndLast(int[] arr, int x) {
        ArrayList<Integer> result = new ArrayList<>();
        int first = firstOccurance(arr, x);
        int second = lastOccurance(arr, x);
        result.add(first);
        result.add(second);
        return result;
    }

    private static int firstOccurance(int[] arr, int x) {
        int ans = 0;
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == x){
                ans = mid;
                high =  mid-1;
            }
            else if(arr[mid] < x){
                low  = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }

    private static int lastOccurance(int[] arr, int x) {
        int ans = 0;
        int low = 0;
        int high = arr.length - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==x){
                ans = mid;
                low = mid+1;
            }
            else if(arr[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}
