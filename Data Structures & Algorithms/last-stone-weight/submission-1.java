class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                if (a > b) return -1;
                return a < b ? 1 : 0;
            }
        });

        for (int i: stones) {
            pq.offer(i);
        }
        while (!pq.isEmpty()) {
            int a = pq.poll();
            int b = pq.poll();
            if (a < b) {
                pq.offer(b-a);
            } else {
                pq.offer(a-b);
            }
            if (pq.size() == 1) return pq.peek();
        }
        return 0;
    }
}

// 2 3 6 2 4
//  6 4 
// 2 3 2 2
// 3 2 
// 2 2 1
// 2 2 

