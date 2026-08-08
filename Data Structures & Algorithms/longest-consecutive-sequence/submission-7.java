class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int count = 1;
                int tmp = nums[i];
                while (set.contains(tmp+1)) {
                    tmp = tmp+1;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
