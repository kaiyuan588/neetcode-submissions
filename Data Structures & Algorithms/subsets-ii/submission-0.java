class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }
    public void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return ;
        }


        path.add(nums[index]);
        dfs(nums, index+1, path, res);
        path.remove(path.size()-1);
        while (index < nums.length-1 && nums[index] == nums[index+1]) {
            index++;
        }
        dfs(nums, index+1, path, res);

    }
}
