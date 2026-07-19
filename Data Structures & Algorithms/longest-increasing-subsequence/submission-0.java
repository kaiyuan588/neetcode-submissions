class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length]; // dp i means the longest increasing subseq from [0..i]
        int res = 1;
        dp[0] = 1;

        //[1, 1, 2, ]
        for (int i = 1; i < nums.length; i++) {
            int longest = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    longest = Math.max(longest, dp[j]+1);
                }
            }
            dp[i] = longest;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
