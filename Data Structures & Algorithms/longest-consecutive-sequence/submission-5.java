class Solution {
    // public int longestConsecutive(int[] nums) {
    //     if (nums == null || nums.length == 0) return 0;
    //     Arrays.sort(nums);

    //     int res = 1;
    //     int cur = 1;

    //     for (int i = 1; i < nums.length; i++) {
    //         if (nums[i] == nums[i-1]) {
    //             continue;
    //         }
    //         if (nums[i] == nums[i-1]+1) {
    //             cur++;
    //         } else {
    //             cur = 1;
    //         }

    //         res = Math.max(cur, res);
    //     }
    //     return res;
    // }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int res = 1;
        int cur = 1;
        for (int i: set) {
            if (set.contains(i-1)) {
                continue;
            }
            int tmp = i;
            while (set.contains(tmp+1)) {
                cur++;
                tmp++;
            }
            res = Math.max(cur, res);
            cur = 1;
        }
        return res;
    }
}
