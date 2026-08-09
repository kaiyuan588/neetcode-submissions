class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
            //    i  l     r
        for (int i = 0; i < n-1; i++) {
            int l = i+1;
            int r = n-1;
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    res.add(tmp);
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r-1]) {
                        r--;
                    } 
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}


