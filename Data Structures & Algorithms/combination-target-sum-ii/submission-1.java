class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, new ArrayList<>(), res);
        return res;
    }
    public void dfs(int[] candi, int start, int curSum, int target, List<Integer> path, List<List<Integer>> res) {
        if (curSum == target) {
            List<Integer> tmp = new ArrayList<>();
            for (int i: path) tmp.add(i);
            res.add(tmp);
            return ;
        }
        if (start == candi.length) {
            return ;
        } 

        for (int i = start; i < candi.length; i++) {
            if (candi[i] + curSum > target) {
                continue;
            }
            if (i > start && candi[i] == candi[i-1]) {
                continue;
            }
            path.add(candi[i]);
            dfs(candi, i+1, curSum + candi[i], target, path, res);
            path.remove(path.size() - 1);
        }
    }
}
