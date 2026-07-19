class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        build(times, g);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                if (a1[1] < a2[1]) return -1;
                return (a1[1] > a2[1]) ? 1 : 0;
            }
        });
        int seen = 0;
        boolean[] visited = new boolean[n+1];
        pq.offer(new int[]{k, 0});
        int res = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int key = cur[0];
            int dis = cur[1];
            if (visited[key]) {
                continue;
            }
            visited[key] = true;
            seen++;
            res = Math.max(res, dis);
            List<int[]> neis = g.get(key);
            if (neis != null) {
                for (int[] nei: neis) {
                    pq.offer(new int[]{nei[0], dis+nei[1]});
                }
            }
        }
        return seen == n ? res : -1;
    }

    public void build(int[][] times, Map<Integer, List<int[]>> g) {
        for (int i = 0; i < times.length; i++) {
            int[] cur = times[i];
            if (!g.containsKey(cur[0])) {
                g.put(cur[0], new ArrayList<>());
            }
            g.get(cur[0]).add(new int[]{cur[1], cur[2]});
        }
    }
}
