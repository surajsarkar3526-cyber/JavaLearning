package HashMap;
import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {

        int[] arr = {0, -1, 2, -3, 1};
        int target = -2;

        boolean ans = twoSum(arr, target);

        System.out.println(ans);
    }

    private static boolean twoSum(int[] arr, int target) {

        Arrays.sort(arr);
        int n = arr.length;
        int  i=0;
        int j = n-1;

        while(i < j){

            if(arr[i] + arr[j] > target){
                j--;
            }
            else if(arr[i] + arr[j] < target){
                i++;
            }
            else{
                return true;
            }
        }

        return false;
    }
}
