class KthLargest {
    PriorityQueue<Integer> pq;
    int size;
    public KthLargest(int k, int[] nums) {
        this.size = k;
        this.pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() != k) {
                pq.offer(nums[i]);
            } else {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
    }
    public int add(int val) {
        if (pq.size() != size) {
            pq.offer(val);
        } else {
            if (pq.peek() < val) {
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}
// k largest 