class Solution {
    int[] arr;
    public boolean validTree(int n, int[][] edges) {
        // if (edges.length != n - 1) return false;
        Map<Integer, List<Integer>> g = new HashMap<>();
        build(g, n, edges);

        Set<Integer> seen = new HashSet<>();
        if (hasCycle(g, 0, -1, seen)) {
            return false;
        }
        return seen.size() == n;
    }
    public void build(Map<Integer, List<Integer>> g, int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
        }
        for (int[] e: edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
    }
    public boolean hasCycle(Map<Integer, List<Integer>> g, int cur, int prev, Set<Integer> seen) {
        if (seen.contains(cur)) {
            return true;
        }
        seen.add(cur);
        for (int nei: g.get(cur)) {
            if (nei == prev) continue;

            if (hasCycle(g, nei, cur, seen)) {
                return true;
            }
        }
        return false;
    }
}
