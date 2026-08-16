class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int rob1 = max(nums, 0, nums.length-2);
        int rob2 = max(nums, 1, nums.length-1);
        return Math.max(rob1, rob2);
    }

    public int max(int[] nums, int from, int to) {
        int n = nums.length;
        int[] dp = new int[n]; // dp i means max rob at i
        dp[from] = nums[from];
        dp[from+1] = Math.max(nums[from], nums[from+1]);

        for (int i = from+2; i <= to; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[to];
    }
}
