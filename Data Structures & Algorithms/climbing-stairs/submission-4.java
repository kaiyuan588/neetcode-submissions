class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // int[] dp = new int[n];
        // dp[0] = 1;
        // dp[1] = 2;

        int pre1 = 1;
        int pre2 = 2;

        for (int i = 2; i < n; i++) {
            int c = pre1 + pre2;
            pre1 = pre2;
            pre2 = c;
        }
        return pre2;
    }
}


