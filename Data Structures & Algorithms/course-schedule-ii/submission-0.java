class Solution {
    Map<Integer, List<Integer>> map;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        int[] indegree = new int[numCourses];
        build(prerequisites, indegree);
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int finished = 0;
        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            finished++;
            List<Integer> neighbor = map.get(cur);
            if (neighbor == null) continue;
            for (int nei: neighbor) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        int[] output = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            output[i] = res.get(i);
        }
        if (finished == numCourses) {
            return output;
        }
        return new int[]{};
    }

    public void build(int[][] pre, int[] indegree) {
        for (int[] edge: pre) {
            int a = edge[0];
            int b = edge[1];
            if (!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(a);
            indegree[a]++;
        }
    }
}
