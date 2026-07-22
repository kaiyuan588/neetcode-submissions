class Solution {
    public int maxProfit(int[] prices) {
        
        int res = 0;

        int curMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            curMin = Math.min(curMin, prices[i]);
            res = Math.max(res, prices[i] - curMin);
        }

        return res;
    }
}
