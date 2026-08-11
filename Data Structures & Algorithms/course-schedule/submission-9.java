class Solution {
    Map<Integer, List<Integer>> g;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        g = new HashMap<>();
        int[] indegree = new int[numCourses];
        build(prerequisites, indegree);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int finished = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            finished++;
            List<Integer> neighbor = g.get(cur);
            if (neighbor == null) {
                continue;
            }
            for (int nei: neighbor) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        return finished == numCourses;
    }

    public void build(int[][] pre, int[] indegree) {
        for (int[] edges: pre) {
            int a = edges[0];
            int b = edges[1];
            if (!g.containsKey(b)) {
                g.put(b, new ArrayList<>());
            }
            g.get(b).add(a);
            indegree[a]++;
        }
    }
}