class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }

    public void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> path) {
        if (index == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i: path) {
                tmp.add(i);
            }
            res.add(tmp);
            return ;
        }
        path.add(nums[index]);
        dfs(nums, index+1, res, path);
        path.remove(path.size()-1);
        dfs(nums, index+1, res, path);
    }
}
