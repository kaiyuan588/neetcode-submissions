class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob1(nums, 0, nums.length-2), rob1(nums, 1, nums.length-1));
    }

    public int rob1(int[] nums, int start, int end) {
        int prev1 = nums[start];
        int prev2 = Math.max(prev1, nums[start+1]);

        int res = Math.max(prev1, prev2);
        for (int i = start+2; i <= end; i++) {
            int rob = nums[i] + prev1;
            int noRob = prev2;

            int cur = Math.max(rob, noRob);
            res = Math.max(cur, res);
            prev1 = prev2;
            prev2 = cur;
        }
        return res;
    }
}
