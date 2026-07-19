class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int maxSofar = nums[0];
        int minSofar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmpMax = Math.max(nums[i], Math.max(nums[i] * maxSofar, nums[i] * minSofar));
            minSofar = Math.min(nums[i], Math.min(nums[i] * maxSofar, nums[i] * minSofar));
            maxSofar = tmpMax;
            res = Math.max(maxSofar, res);
        }
        return res;
    }
}
