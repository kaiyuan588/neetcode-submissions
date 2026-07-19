class Solution {
    public int trap(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) return res;

        for (int i = 0; i < height.length; i++) {
            int left = i;
            int right = i;
            int leftMax = height[left];
            int rightMax = height[right];

            while (left >= 0) {
                leftMax = Math.max(leftMax, height[left]);
                left--;
            }
            while (right < height.length) {
                rightMax = Math.max(rightMax, height[right]);
                right++;
            }
            res = res + (Math.min(leftMax, rightMax) - height[i] <= 0 ? 0 : Math.min(leftMax, rightMax) - height[i]);
        }
        return res;
    }
}


// for each index, we need to find the max of the left and the max of the right
// the stored water for the current index is Math.min(leftMax, rightMax) - current value