class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length]; 
        // dp i means the min jump to reach i => if there exists a j < i that j + nums[j] >= i and take the min from all j

        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    min = Math.min(min, dp[j]);
                }
            }
            dp[i] = min+1;
        }

        return dp[dp.length-1];
    }
}
