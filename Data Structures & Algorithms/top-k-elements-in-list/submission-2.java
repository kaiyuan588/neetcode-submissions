class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (map.get(a) < map.get(b)) {
                    return -1;
                }
                return map.get(a) > map.get(b) ? 1 : 0;
            }
        });

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry.getKey());
            } else {
                if (map.get(entry.getKey()) > map.get(minHeap.peek())) {
                    minHeap.poll();
                    minHeap.offer(entry.getKey());
                } 
            }
        }

        int[] res = new int[minHeap.size()];
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll();
        }
        return res;
    }
}
