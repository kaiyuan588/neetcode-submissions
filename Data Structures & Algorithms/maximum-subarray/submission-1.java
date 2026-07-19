class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int dp = nums[0]; // dp i means the max subarray sum of ith position
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + dp < nums[i]) {
                dp = nums[i];
            } else {
                dp = nums[i] + dp;
            }
            max = Math.max(max, dp);
        }
        return max;
    }
}
