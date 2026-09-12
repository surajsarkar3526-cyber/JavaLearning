package Arrays;

public class StockBuySellMax2 {
    public static int maxProfit(int[] prices) {
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
    static void main(String[] args) {
        int[] prices = {10, 22, 5, 75, 65, 80};
        int result = maxProfit(prices);
        System.out.println("Maximum Profit = " + result);
    }
}
