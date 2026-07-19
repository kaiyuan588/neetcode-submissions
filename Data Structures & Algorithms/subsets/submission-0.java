class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }
    public void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return ;
        }
        list.add(nums[index]);
        dfs(nums, index+1, list, res);
        list.remove(list.size()-1);
        dfs(nums, index+1, list, res);
    }
}
