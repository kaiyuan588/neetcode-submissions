class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            int rob = nums[i] + dp[i-2];
            int noRob = dp[i-1];
            dp[i] = Math.max(rob, noRob);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

// dp[i] = nums[i] + dp[i-2];


// 2 9 8 3 6
// r   r.  r -> 16
//   r.   r -> 12

// 5 1 2 10 6 2 7 9 3 1 
// r   r.   r.  r.  r.  
//   r.   r.  r.  r.  r