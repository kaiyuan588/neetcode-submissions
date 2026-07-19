class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);

        for (int cur = 0; cur < nums.length; cur++) {
            if (cur > 0 && nums[cur] == nums[cur - 1]) {
                continue;
            }
            int left = cur+1;
            int right = nums.length-1;
            
            while (left < right) {
                List<Integer> tmp = new ArrayList<>();
                int sum = nums[cur] + nums[left] + nums[right];
                if (sum == 0) {
                    tmp.add(nums[cur]);
                    tmp.add(nums[left++]);
                    tmp.add(nums[right--]);
                    res.add(tmp);
                    while (left < right && nums[left] == nums[left-1]) left++;
                    while (left < right && nums[right] == nums[right+1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
