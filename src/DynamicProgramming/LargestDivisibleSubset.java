package DynamicProgramming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class LargestDivisibleSubset {
    static int[] dp;
    static int solve(int[] arr, int i){
        if(dp[i] != -1){
            return dp[i];
        }
        int maxlength = 1;
        for(int j=i+1; j<arr.length; j++){
            if(arr[j]%arr[i] == 0){
                int length = 1 + solve(arr, j);
                maxlength = Math.max(maxlength, length);
            }
        }
        return dp[i] = maxlength;
    }
    public static void main(String[] args) {
        int[] arr = {1, 16, 7, 8, 4};
        int n = arr.length;
        Arrays.sort(arr);
        dp = new int[n];
        Arrays.fill(dp, -1);
        int maxlength = 0;
        for(int i=0; i<n; i++) {
            maxlength = Math.max(maxlength, solve(arr, i));
        }
        List<Integer> result = new ArrayList<>();
        int prev = -1;
        int remaining = maxlength;
        for(int j = n-1; j>=0; j--){
            if(remaining == 0){
                break;
            }
            if(prev == -1){
                if(dp[j] == remaining){
                    result.add(arr[j]);
                    prev = arr[j];
                    remaining--;
                }
            }
            else{
                if(arr[j] % prev == 0 && dp[j] == remaining){
                    result.add(arr[j]);
                    prev = arr[j];
                    remaining--;
                }
            }
        }
        Collections.reverse(result);
        System.out.println(result);
    }
}
