class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        
        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);

        int res = Math.max(prev1, prev2);
        for (int i = 2; i < nums.length; i++) {
            int rob = nums[i] + prev1;
            int noRob = prev2;
            int cur = Math.max(rob, noRob);
            res = Math.max(res, cur);
            prev1 = prev2;
            prev2 = cur;
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