class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        build(n, edges, g);
        Set<Integer> seen = new HashSet<>();
        if (!dfs(0, -1, g, seen)) {
            return false;
        }
        return seen.size() == n;
    }

    public boolean dfs(int cur, int pre, Map<Integer, List<Integer>> g, Set<Integer> seen) {
        if (seen.contains(cur)) {
            return false;
        }
        seen.add(cur);
        List<Integer> neis = g.get(cur);
        if (neis != null) {
            for (int nei: neis) {
                if (nei == pre) continue;
                if (dfs(nei, cur, g, seen) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public void build(int n, int[][] edges, Map<Integer, List<Integer>> g) {
        for (int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
        }

        for (int[] e: edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
    }
}
