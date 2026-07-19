class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean canPartition(int[] nums) {
        int remain = 0;
        for (int i: nums) remain += i;
        return dfs(nums, 0, 0, remain);
    }

    public boolean dfs(int[] nums, int index, int cur, int remain) {
        String key = index+"-"+cur+"-"+remain;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (index == nums.length) {
            return false;
        }
        if (cur == remain) {
            return true;
        }
        boolean add = dfs(nums, index+1, cur+nums[index], remain-nums[index]);
        boolean noAdd = dfs(nums, index+1, cur, remain);
        boolean res = add || noAdd;
        memo.put(key, res);
        return res;
    }
}
