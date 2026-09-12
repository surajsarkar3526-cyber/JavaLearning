package DynamicProgramming;

public class HouseRobberIITabulation {
    public static void main(String[] args) {

        int[] nums = {2, 3, 2, 8, 9, 5, 6};

        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        int case1 = robLinear(nums, 0, n - 2);

        int case2 = robLinear(nums, 1, n-1);
        return Math.max(case1, case2);
    }

    private static int robLinear(int[] nums, int i, int n) {
        if(i > n){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[i] = nums[i];

        if(i + 1 <= n){
            dp[i+1] = nums[i+1];
        }
        for(int j = i + 2; j<=n; j++){
            int loot = nums[j] + dp[j - 2];
            int skip = dp[j - 1];

            dp[j] = Math.max(loot,skip);
        }
        return dp[n];
    }
}
