class Solution {
    public int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int max = Integer.MIN_VALUE;

        int left = 0; 
        int right = heights.length-1;

        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(heights[left], heights[right]));
            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }
}
