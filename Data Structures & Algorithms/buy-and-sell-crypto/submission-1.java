class Solution {
    public int maxProfit(int[] prices) {
        int profits = 0;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            profits = Math.max(profits, prices[i] - min);
        }
        return profits;
    }
}
