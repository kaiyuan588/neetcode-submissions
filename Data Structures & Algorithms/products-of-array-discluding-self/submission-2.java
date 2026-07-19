class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] prefix = new int[n];

        int pre = 1;
        for (int i = 0; i < n; i++) {
            prefix[i] = pre * nums[i];
            pre *= nums[i];
        } 

        int[] postfix = new int[n];
        int post = 1;

        for (int j = n-1; j >= 0; j--) {
            postfix[j] = post * nums[j];
            post *= nums[j]; 
        }

        int[] res = new int[n];
        for  (int k = 0; k < n; k++) {
            if (k == 0) {
                res[k] = postfix[k+1];
            } else if (k == n-1) {
                res[k] = prefix[k-1];
            } else {
                res[k] = prefix[k-1] * postfix[k+1];
            }
        }

        return res;
    }
}  


// [1, 2, 8, 48]
// [1, 48, 24, 6]