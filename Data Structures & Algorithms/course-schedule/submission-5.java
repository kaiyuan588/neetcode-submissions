class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        Map<Integer,List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        build(prerequisites, map, indegree);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int finished = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                finished++;
                List<Integer> neis = map.get(cur);
                if (neis == null) {
                    continue;
                }
                for (int nei: neis) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
        }
        return finished == numCourses;
    }
    public void build(int[][] prereq, Map<Integer, List<Integer>> map, int[] indegree) {
        for (int[] edge: prereq) {
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


// 0, 1 take course 1 first take course 0 second