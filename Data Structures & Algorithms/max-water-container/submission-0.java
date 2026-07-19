class Solution {
    public int maxArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                max = Math.max(max, (j - i) * Math.min(heights[j], heights[i]));
            }
        }
        return max;
    }
}
