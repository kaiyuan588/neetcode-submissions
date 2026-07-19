class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        int n = cost.length;

        int[] dp = new int[n+1];

        dp[n] = 0;
        dp[n-1] = cost[n-1];

        for (int i = n-2; i >= 0; i--) {
            dp[i] = Math.min(cost[i] + dp[i+1], cost[i] + dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }
}

//  [1 2 3]
//  [0 0 3 0]
