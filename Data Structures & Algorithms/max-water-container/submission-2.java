class Solution {
    public int maxArea(int[] heights) {

        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i+1; j < heights.length; j++) {
                int cur = Math.min(heights[j], heights[i]) * (j - i);
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}
