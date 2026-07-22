class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rigthMax = new int[n];
        
        int pre = 0;
        for (int i = 0; i < n; i++) {
            leftMax[i] = Math.max(pre, height[i]);
            pre = leftMax[i];
        } 

        int suf = 0;
        for (int i = n - 1; i >= 0; i--) {
            rigthMax[i] = Math.max(suf, height[i]);
            suf = rigthMax[i];
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rigthMax[i]) - height[i];
        }
        return res;
    }
}


// trap[i] = min(the tallest from the left, the tallest from the right) - height[i] 
