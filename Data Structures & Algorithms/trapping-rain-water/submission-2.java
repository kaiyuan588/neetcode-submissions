class Solution {
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        if (height == null || n == 0) return res;
        
        int leftMax = height[0];
        int rightMax = height[n-1];
        int left = 0; 
        int right = n-1;

        while (left < right) {
            if (height[left] <= height[right]) {
                left++;
                int tmp = Math.min(leftMax, rightMax) - height[left];
                res += (tmp <= 0 ? 0 : tmp);
                leftMax = Math.max(leftMax, height[left]);
            } else {
                right--;
                int tmp = Math.min(leftMax, rightMax) - height[right];
                res += (tmp <= 0 ? 0 : tmp);
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return res;
    }
}


// for each index, we need to find the max of the left and the max of the right
// the stored water for the current index is Math.min(leftMax, rightMax) - current value