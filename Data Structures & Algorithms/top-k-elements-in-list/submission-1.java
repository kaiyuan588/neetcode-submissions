class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (count.get(a) < count.get(b)) {
                    return -1;
                }
                return count.get(a) > count.get(b) ? 1 : 0;
            }
        });

        for (int num: count.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            res[idx++] = minHeap.poll();
        }

        return res;
    }
}
