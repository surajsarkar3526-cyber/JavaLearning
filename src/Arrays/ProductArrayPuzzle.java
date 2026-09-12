package Arrays;
import java.util.Arrays;
public class ProductArrayPuzzle {
    public static void main(String[] args){
        int[] arr = {10, 3, 5, 6, 2};
        int[] result = productExceptSelf(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1; i<n; i++){
            res[i] = res[i-1] * arr[i-1];
        }
        int suffix = 1;
        for(int j = n-1; j>=0; j--){
            res[j] = res[j] * suffix;
            suffix = arr[j] * suffix;
        }
        return res;
    }
}
