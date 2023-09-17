package LeetCode;

public class LC0122_BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[] dp = new int[prices.length];
        dp[0] = 0;
        dp[1] = Math.max(0, prices[1] - prices[0]);
        int min = Math.min(prices[1], prices[0]);

        // 记录利润是否还在上升，是，保持股票，否，抛售
        int increase = dp[1];
        int sum = 0;

        for (int i = 2; i < prices.length; i++) {
            if (prices[i] - min > increase) {
                dp[i] = prices[i] - min;
                increase = prices[i] - min;
            } else {
                sum += dp[i - 1]; // 结算
                dp[i] = 0;
                increase = 0;
                min = prices[i];
            }
        }

        return sum + dp[prices.length - 1];
    }

}
