class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length]; // dp i means the max subarray sum of ith position
        dp[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + dp[i-1] < nums[i]) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i-1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
