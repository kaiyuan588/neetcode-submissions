class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n]; // max subarray sum at dp[i]
        
        int dp0 = nums[0];
        // dp[0] = nums[0];
        int res = dp0;
        for (int i = 1; i < n; i++) {
            int dp1 = 0;
            if (dp0+ nums[i] < nums[i]) {
                dp1 = nums[i];
            } else {
                dp1 = dp0 + nums[i];
            }
            res = Math.max(res, dp1);
            dp0 = dp1;
        }
        return res;
    }
}
