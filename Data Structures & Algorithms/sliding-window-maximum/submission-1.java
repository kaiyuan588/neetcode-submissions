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
        for (int i = 0; i < k; i++) {
            max.offer(new int[]{i, nums[i]});
        }
        res[0] = max.peek()[1];

        int index = 1;
        int left = 1;
        for (int right = k; right < nums.length; right++) {
            max.offer(new int[]{right, nums[right]});
            // cal res
            while (!max.isEmpty() && (max.peek()[0] < left || max.peek()[0] > right)) {
                max.poll();
            }
            res[index++] = max.peek()[1];
            left++;
        }
        return res;
    }
}
