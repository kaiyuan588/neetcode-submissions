class Solution {
    public int maxArea(int[] heights) {

        int max = 0;

        int n = heights.length;
        int l = 0;
        int r = n-1;

        while (l < r) {
            int cur = Math.min(heights[l], heights[r]) * (r - l);
            max = Math.max(max, cur);
            if (heights[l] < heights[r]) {
                l++;
            } else if (heights[l] > heights[r]) {
                r--;
            } else {
                l++;
                r--;
            }
        }

        return max;
    }
}
