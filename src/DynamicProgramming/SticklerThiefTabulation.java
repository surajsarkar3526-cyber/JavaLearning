package DynamicProgramming;

public class SticklerThiefTabulation {
    public static void main(String[] args) {
        int[] arr = {6, 7, 1, 3, 8, 2, 4};

        System.out.println(maxLoot(arr));
    }

    private static int maxLoot(int[] arr) {

        int n = arr.length;
        if(n == 1){
            return arr[0];
        }

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i=2; i<n; i++){
            int loot = arr[i] + dp[i - 2];
            int skip = dp[i - 1];

            dp[i] = Math.max(loot, skip);
        }

        return dp[n - 1];
    }
}
