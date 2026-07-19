class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        PriorityQueue<int[]> max = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] > b[1]) return -1;
                return a[1] < b[1] ? 1 : 0;
            }
        });
        int index = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            max.offer(new int[]{right, nums[right]});
            int len = right - left + 1;
            if (len == k) {
                // cal res
                while (!max.isEmpty() && (max.peek()[0] < left || max.peek()[0] > right)) {
                    max.poll();
                }
                res[index++] = max.peek()[1];
                left++;
            } else if (len > k) {
                left++;
            }
        }
        return res;
    }
}
