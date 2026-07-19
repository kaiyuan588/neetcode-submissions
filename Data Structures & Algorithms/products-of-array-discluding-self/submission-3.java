class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        int pre = 1;
        for (int i = 0; i < n; i++) {
            // product of [0,i-1]
            res[i] = pre;
            pre = pre * nums[i];
        } 

        int post = 1;

        for (int j = n-1; j >= 0; j--) {
            // product of [j+1, n-1];
            res[j] = post * res[j];
            post = post * nums[j];
        }

        return res;
    }
}  
// [1,1,2,8]

// [1, 2, 8, 48]
// [1, 48, 24, 6]