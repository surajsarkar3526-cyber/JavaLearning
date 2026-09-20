package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class CountNonAdjacentSubsets {
    static final int MOD = 1_000_000_007;
    public static int countNonAdjacentSubsets(int[] parent, int[] nums, int k) {
        int n = parent.length;
        List<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
        long[][][] dp = new long[n][2][k];
        dfs(0, children, nums, k, dp);
        long answer = (dp[0][0][0] + dp[0][1][0]) % MOD;
        answer = (answer - 1 + MOD) % MOD;
        return (int) answer;
    }
    static void dfs(int node,List<Integer>[] children,int[] nums,int k,long[][][] dp){
        dp[node][0][0] = 1;
        int remainder = nums[node] % k;
        dp[node][1][remainder] = 1;
        for (int child : children[node]) {
            dfs(child, children, nums, k, dp);
            long[][] newDp = new long[2][k];
            for (int r1 = 0; r1 < k; r1++) {
                if (dp[node][0][r1] == 0) {
                    continue;
                }
                for (int r2 = 0; r2 < k; r2++) {
                    long waysChild = (dp[child][0][r2] + dp[child][1][r2]) % MOD;
                    if (waysChild == 0) {
                        continue;
                    }
                    int newRemainder = (r1 + r2) % k;
                    newDp[0][newRemainder] = (newDp[0][newRemainder]+ dp[node][0][r1] * waysChild) % MOD;
                }
            }
            for (int r1 = 0; r1 < k; r1++) {
                if (dp[node][1][r1] == 0) {
                    continue;
                }
                for (int r2 = 0; r2 < k; r2++) {
                    if (dp[child][0][r2] == 0) {
                        continue;
                    }
                    int newRemainder = (r1 + r2) % k;
                    newDp[1][newRemainder] = (newDp[1][newRemainder] + dp[node][1][r1] * dp[child][0][r2]) % MOD;
                }
            }
            dp[node] = newDp;
        }
    }
    public static void main(String[] args) {

        int[] parent = {-1, 0, 1};
        int[] nums = {1, 2, 3};
        int k = 3;
        int answer = countNonAdjacentSubsets(parent, nums, k);
        System.out.println(answer);
    }
}
