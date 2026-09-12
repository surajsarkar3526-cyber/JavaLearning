package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;

        int result = findTargetSumWays(arr, target);
        System.out.println("Number of Ways: " + result);
    }

    private static int findTargetSumWays(int[] arr, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return solve(arr, 0, 0, target, dp);
    }

    private static int solve(int[] arr, int index, int currentSum, int target, Map<String, Integer> dp) {
        if(index == arr.length){
            if(currentSum == target){
                return 1;
            }
            return 0;
        }
        String key = index + "," + currentSum;
        if(dp.containsKey(key)){
            return dp.get(key);
        }

        int add = solve(arr, index+1, currentSum+arr[index], target, dp);
        int subtract = solve(arr, index + 1, currentSum-arr[index], target, dp);
        int ways = add + subtract;
        dp.put(key, ways);

        return ways;
    }
}
