class Solution {


    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0;
        int[] dp = new int[amount+1]; // dp[i] means whats the min numbers of coin to make up i amount
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin: coins) {
                int remain = i - coin;
                if (remain < 0) continue;
                min = Math.min(dp[remain], min);
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        return dp[dp.length-1] == Integer.MAX_VALUE ? - 1: dp[dp.length-1];
    }


}