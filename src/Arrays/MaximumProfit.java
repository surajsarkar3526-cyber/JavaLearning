package Arrays;

public class MaximumProfit {
    public static void main(String[] args){
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(maximumProfit(prices));
    }

    private static int maximumProfit(int[] prices) {
        int n = prices.length;
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i=1; i<n; i++){
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
