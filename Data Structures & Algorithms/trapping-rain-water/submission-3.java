class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        
        int pre = 0;
        for (int i = 0; i < n; i++) {
            prefix[i] = Math.max(pre, height[i]);
            pre = prefix[i];
        } 

        int suf = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = Math.max(suf, height[i]);
            suf = suffix[i];
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(prefix[i], suffix[i]) - height[i];
        }
        return res;
    }
}


// trap[i] = min(the tallest from the left, the tallest from the right) - height[i] 
