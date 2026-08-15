class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n]; // max subarray sum at dp[i]

        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i-1] + nums[i] < nums[i]) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i-1] + nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
