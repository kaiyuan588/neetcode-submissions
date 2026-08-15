class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (n == 1) {
            return nums[0];
        }
        // int[] dp = new int[n];
        int rob0 = nums[0];
        int rob1 = Math.max(nums[0], nums[1]);
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0], nums[1]);

        int res = Math.max(rob0, rob1);
        for (int i = 2; i < n; i++) {
            int cur = Math.max(nums[i]+rob0, rob1);
            res = Math.max(res, cur);
            rob0 = rob1;
            rob1 = cur;
        }
        return res;
    }
}

