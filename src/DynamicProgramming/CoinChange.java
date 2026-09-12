package DynamicProgramming;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {9, 6, 5, 1};
        int sum = 19;

        int result = minCoins(coins, sum);
        if(result == Integer.MAX_VALUE){
            System.out.println("Minimum Coins : -1");
        }
        else{
            System.out.println("Minimum Coins : " + result);
        }
    }

    private static int minCoins(int[] coins, int sum) {

        if(sum == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            if(coin <= sum){
                int result = minCoins(coins, sum-coin);
                if(result != Integer.MAX_VALUE){
                    min = Math.min(min, 1 + result);
                }
            }
        }
        return min;
    }
}
