class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return true;

        boolean[] dp = new boolean[nums.length]; 
        // dp i means if there exist an path can reach to index i => if theres a index j less than i that dp[j] == true (means can jump to j) AND j+dp[j] >= i (means can jump to i)
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length-1];
    }
}
