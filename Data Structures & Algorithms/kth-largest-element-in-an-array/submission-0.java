class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            if (pq.size() != k) {
                pq.offer(i);
            } else {
                if (i > pq.peek()) {
                    pq.poll();
                    pq.offer(i);
                }
            }
        }
        return pq.peek();
    }
}
