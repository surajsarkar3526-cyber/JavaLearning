package DynamicProgramming;
import java.util.Arrays;
public class HouseRobberII {
    public static void main(String[] args) {

        int[] nums = {2, 3, 2,8,9,5,6};

        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {

        int n = nums.length;

        if(n == 1){
            return nums[0];
        }

        int[] dp1  = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = Solve(nums, 0, n-2, dp1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = Solve(nums, 1, n-1, dp2);

        return Math.max(case1, case2);
    }

    private static int Solve(int[] nums, int i, int j, int[] dp) {

        if(i > j){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int loot = nums[i] + Solve(nums, i + 2, j, dp);
        int skip = Solve(nums, i + 1, j, dp);

        dp[i] = Math.max(loot, skip);
        return dp[i];
    }
}
