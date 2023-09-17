package LeetCode;

public class LC0121_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[] dp = new int[prices.length];
        dp[0] = 0;
        dp[1] = Math.max(0, prices[1] - prices[0]);
        // int max = Math.max(dp[0], dp[1]); // 记录当前的最大利润
        int min = Math.min(prices[0], prices[1]); // 指向最低的股票价格
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            // dp[i] = max;
        }

        return dp[prices.length - 1];

    }

}
