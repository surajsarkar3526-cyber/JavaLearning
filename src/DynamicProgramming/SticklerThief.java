package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class SticklerThief {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size : ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        System.out.println(maxLoot(arr, arr.length - 1, dp));
    }

    private static int maxLoot(int[] arr, int i, int[] dp) {
        if(i < 0){
            return 0;
        }
        if(i == 0){
            return arr[0];
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int loot = arr[i] + maxLoot(arr, i-2, dp);
        int skip = maxLoot(arr, i - 1, dp);

        dp[i] = Math.max(skip, loot);

        return dp[i];
    }
}
