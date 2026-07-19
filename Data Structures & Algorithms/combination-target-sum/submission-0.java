class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, 0, new ArrayList<>(), res, target);
        return res;
    }

    public void dfs(int[] nums, int index, int curSum, List<Integer> path, List<List<Integer>> res, int target) {
        if (curSum == target) {
            List<Integer> tmp = new ArrayList<>();
            for (int i: path) tmp.add(i);
            res.add(tmp);
        }
        if (index == nums.length) {
            return ;
        }
        for (int i = index; i < nums.length; i++) {
            if (curSum + nums[i] > target) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i, curSum+nums[i], path, res, target);
            path.remove(path.size()-1);
        }
    }
}
