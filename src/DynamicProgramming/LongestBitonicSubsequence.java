package DynamicProgramming;
import java.util.Arrays;
public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];
        Arrays.fill(lis, -1);
        Arrays.fill(lds, -1);
        int max = 0;
        for(int i=0; i<n; i++){
            int increasing = lis(nums, i, lis);
            int decreasing = lds(nums, i, lds);

            int bitonic = increasing + decreasing - 1;
            if(increasing > 1 && decreasing > 1){
                max = Math.max(max, bitonic);
            }
        }
        System.out.println(max);
    }

    private static int lds(int[] arr, int i, int[] dp) {
        if(dp[i] != -1){
            return dp[i];
        }
        int max = 1;
        for(int j = i+1; j<arr.length; j++){
            if(arr[j] < arr[i]){
                int result = lds(arr, j, dp);
                max = Math.max(max, 1+result);
            }
        }
        return dp[i] = max;
    }

    private static int lis(int[] arr, int i, int[] dp) {
        if(dp[i] != -1) {
            return dp[i];
        }
        int max = 1;
        for(int j=0; j<i; j++){
            if(arr[j] < arr[i]){
                int result = lis(arr, j, dp);
                max = Math.max(max, 1 + result);
            }
        }
        return dp[i] = max;
    }
}
