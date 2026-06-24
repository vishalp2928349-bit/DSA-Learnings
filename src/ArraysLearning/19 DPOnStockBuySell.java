package ArraysLearning;

 class DPOnStockBuySell {
    public static void main(String[] args) {

    }

    public static int maximumProfit(int[] prices) {
        int maxProfit = 0;
        int mini = prices[0];

        for (int i = 0; i < prices.length; i++) {
            int cost = prices[i] - mini;
            maxProfit = Math.max(maxProfit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return maxProfit;
    }
}
