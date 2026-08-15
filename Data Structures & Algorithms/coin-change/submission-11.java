class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount+1]; // dp i means min number of coin to make up to this amount
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i-coin]+1, dp[i]);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
