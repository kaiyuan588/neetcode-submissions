class Solution {
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        if (height == null || n == 0) return res;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int lMax = height[0];
        int rMax = height[n-1];

        leftMax[0] = lMax;
        rightMax[n-1] = rMax;

        for (int i = 1; i < n; i++) {
            leftMax[i] = lMax;
            lMax = Math.max(lMax, height[i]);
        }

        for (int j = n-2; j >= 0; j--) {
            rightMax[j] = rMax;
            rMax = Math.max(rMax, height[j]);
        }

        for (int i = 0; i < n; i++) {
            int tmp = Math.min(leftMax[i], rightMax[i]) - height[i];
            res += (tmp <= 0 ? 0 : tmp);
        }
        return res;
    }
}


// for each index, we need to find the max of the left and the max of the right
// the stored water for the current index is Math.min(leftMax, rightMax) - current value