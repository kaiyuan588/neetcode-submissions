class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        dfs(nums, 0, res);
        return res;
    }

    public void dfs(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i: nums) tmp.add(i);
            res.add(tmp);
            return ;
        }
        
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            dfs(nums, index+1, res);
            swap(nums, i, index);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
