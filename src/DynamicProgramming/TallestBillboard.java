package DynamicProgramming;

import java.util.Arrays;

public class TallestBillboard {
    public int tallestBillboard(int[] rods) {
        int total = 0;
        for (int rod : rods) {
            total += rod;
        }
        int[] dp = new int[total + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int rod : rods) {
            int[] old = dp.clone();
            for (int diff = 0; diff <= total - rod; diff++) {
                if (old[diff] == -1) {
                    continue;
                }
                int shorter = old[diff];
                dp[diff] = Math.max(dp[diff], shorter);
                int newDiff = diff + rod;
                dp[newDiff] = Math.max(dp[newDiff],shorter);
                newDiff = Math.abs(diff - rod);
                int newShorter = shorter + Math.min(diff, rod);
                dp[newDiff] = Math.max(dp[newDiff],newShorter);
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        TallestBillboard solution = new TallestBillboard();
        int[] rods = {1, 2, 3, 6};
        System.out.println(solution.tallestBillboard(rods));
    }
}
