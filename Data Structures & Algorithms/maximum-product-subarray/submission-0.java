class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int maxPro = nums[0] < 0 ? 0 : nums[0];
        int minPro = nums[0] > 0 ? 0 : nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmpMax = Math.max(nums[i], Math.max(nums[i] * maxPro, nums[i] * minPro));
            minPro = Math.min(nums[i], Math.min(nums[i] * maxPro, nums[i] * minPro));
            maxPro = tmpMax;
            res = Math.max(maxPro, res);
        }
        return res;
    }
}
