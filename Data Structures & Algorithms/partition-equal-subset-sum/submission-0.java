class Solution {
    public boolean canPartition(int[] nums) {
        int remain = 0;
        for (int i: nums) remain += i;
        return dfs(nums, 0, 0, remain);
    }

    public boolean dfs(int[] nums, int index, int cur, int remain) {
        if (index == nums.length) {
            return false;
        }
        if (cur == remain) {
            return true;
        }
        boolean add = dfs(nums, index+1, cur+nums[index], remain-nums[index]);

        boolean noAdd = dfs(nums, index+1, cur, remain);

        if (add || noAdd) {
            return true;
        }
        return false;
    }
}
