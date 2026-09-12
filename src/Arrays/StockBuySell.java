package Arrays;

public class StockBuySell {
    public static void main(String[] args){
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        int result = maxProfit(prices);
        System.out.println("Maximum Profit : " + result);
    }
    private static int maxProfit(int[] prices){
        int profit = 0;
        for(int i = 1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
