package Binary_Search;

import Arrays.MaximumElementOfArray;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int answer = minSubArrayLen(target, nums);
        System.out.println(answer);
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minlength = Integer.MAX_VALUE;
        int sum = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                int currentLength = right - left + 1;
                minlength = Math.min(minlength, currentLength);
                sum -= nums[left];
                left++;
            }
        }
        if(minlength == Integer.MAX_VALUE){
            return 0;
        }
        return minlength;
    }
}
