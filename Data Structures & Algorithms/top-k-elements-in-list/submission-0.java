class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i: nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (countMap.get(a) < countMap.get(b)) return -1;
                return countMap.get(a) > countMap.get(b) ? 1 : 0;
            }
        });

        for (Integer key: countMap.keySet()) {
            if (minHeap.size() != k) {
                minHeap.offer(key);
            } else {
                if (countMap.get(minHeap.peek()) < countMap.get(key)) {
                    minHeap.poll();
                    minHeap.offer(key);
                }
            }
        }
        int[] res = new int[k]; 
        int i = 0;
        while (!minHeap.isEmpty()) {
            res[i++] = minHeap.poll();
        }
        return res;
    }
}
