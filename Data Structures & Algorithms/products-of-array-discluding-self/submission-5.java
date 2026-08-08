class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return new int[]{};
        }

        // 1 1 2 8
        //     12 8
        int[] res = new int[n];

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix = prefix * nums[i];
        }

        int suffix = 1;
        for (int i = n-1; i>=0; i--) {
            res[i] = suffix * res[i];
            suffix = suffix * nums[i];
        }
        return res;
    }
}  
