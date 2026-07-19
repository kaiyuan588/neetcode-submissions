class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        int n = nums.length;
        int[] prefixPro = new int[n];
        
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            prefixPro[i] = prefix * nums[i];
            prefix *= nums[i];
        }

        int postFix = 1;
        int[] output = new int[n];

        for (int i = n-1; i >= 0; i--) {
            if (i == 0) {
                output[i] = 1 * postFix;
            } else {
                output[i] = prefixPro[i-1] * postFix;
                postFix = postFix * nums[i];
            }
        }
        return output;
    }
}  

// 1 2 8 48
//       
