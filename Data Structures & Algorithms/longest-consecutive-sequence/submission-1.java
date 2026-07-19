class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i: nums) {
            set.add(i);
        }
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int tmp = nums[i];
                int tmpLen = 0;
                while (set.contains(tmp)) {
                    tmpLen++;
                    set.remove(tmp);
                    tmp += 1;
                }
                len = Math.max(len, tmpLen);
            }
        }
        return len;
    }
}
