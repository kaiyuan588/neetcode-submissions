class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Deque<int[]> stack = new ArrayDeque<>();
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            if (stack.isEmpty()) {
                stack.offer(new int[]{i, heights[i]});
            } else {
                if (heights[i] >= stack.peekLast()[1]) {
                    stack.offerLast(new int[]{i, heights[i]});
                } else {
                    while (!stack.isEmpty() && heights[i] < stack.peekLast()[1]) {
                        int[] prev = stack.pollLast();
                        res = Math.max(res, ((i - prev[0]) * prev[1]));
                        start = prev[0];
                    }
                    stack.offerLast(new int[]{start, heights[i]});
                }
            }
        }
        while (!stack.isEmpty()) {
            int[] prev = stack.pollLast();
            res = Math.max(res, (heights.length - prev[0]) * prev[1]);
        }

        return res;
    }
}
