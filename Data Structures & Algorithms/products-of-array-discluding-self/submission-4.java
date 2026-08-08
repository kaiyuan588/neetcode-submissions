class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) {
            return new int[]{};
        }
        int[] prefix = new int[n];

        int pre = 1;
        for (int i = 0; i < n; i++) {
            prefix[i] = pre * nums[i];
            pre = prefix[i];
        }

        int suf = 1;
        int[] suffix = new int[n];
        for (int j = n-1; j >= 0; j--) {
            suffix[j] = suf * nums[j];
            suf = suffix[j];
        }
        // 1 2 8 48
        // 48 48 24 6
        int[] res = new int[n];
        for (int k = 0; k < n; k++) {
            if (k == 0) {
                res[k] = suffix[k+1];
            } else if (k == n-1) {
                res[k] = prefix[k-1];
            } else {
                res[k] = prefix[k-1] * suffix[k+1];
            }
        }
        return res;
    }
}  
