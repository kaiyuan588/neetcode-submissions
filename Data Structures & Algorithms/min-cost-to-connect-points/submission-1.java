class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n <= 1) {
            return 0;
        }
        // building graph, key is the node, value is [dis, node]
        Map<Integer, List<int[]>> g = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i+1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                if (!g.containsKey(i)) {
                    g.put(i, new ArrayList<>());
                }
                if (!g.containsKey(j)) {
                    g.put(j, new ArrayList<>());
                }
                g.get(i).add(new int[]{dis, j});
                g.get(j).add(new int[]{dis, i});
            }
        }

        PriorityQueue<int[]> minH = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) return -1;
                return a[0] > b[0] ? 1 : 0;
            }
        });
        
        Set<Integer> visited = new HashSet<>();
        minH.offer(new int[]{0,0});
        int res = 0;

        while (visited.size() != n) {
            int[] cur = minH.poll();
            if (visited.contains(cur[1])) {
                continue;
            }    
            visited.add(cur[1]);
            res += cur[0];

            List<int[]> neis = g.get(cur[1]);

            for (int[] nei: neis) {
                if (!visited.contains(nei[1])) {
                    minH.offer(new int[]{nei[0], nei[1]});
                }
            }
        }
        return res;
    }
}
