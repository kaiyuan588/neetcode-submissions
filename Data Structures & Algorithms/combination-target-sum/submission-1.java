class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), new int[]{0}, target);
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> path, int[] sum, int target) {
        if (sum[0] == target) {
            List<Integer> tmp = new ArrayList<>();
            for (int i: path) tmp.add(i);
            res.add(tmp);
            return ;
        }
        for (int i = index; i < nums.length; i++) {
            if (sum[0] > target) {
                continue;
            }
            path.add(nums[i]);
            sum[0]+= nums[i];
            dfs(nums, i, path, sum, target);
            path.remove(path.size()-1);
            sum[0] -= nums[i];    
        }
    }
}

//         2 5 6 9

//         2 0
//     2+5  2 

// 2+5+6
