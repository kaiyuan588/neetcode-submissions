class Solution {
    int[] arr;
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        build(edges, graph);

        for (int i = edges.length-1; i >= 0; i--) {
            int[] e = edges[i];
            graph.get(e[0]).removeIf(s -> s.equals(e[1]));
            graph.get(e[1]).removeIf(s -> s.equals(e[0]));
            Set<Integer> seen = new HashSet<>();
            if (!isConnected(graph, seen, e[0], e[1], -1)) {
                graph.get(e[0]).add(e[1]);
                graph.get(e[1]).add(e[0]);
                continue;
            } else {
                return e;
            }
        }
        return new int[]{};
    }

    public boolean isConnected(Map<Integer, List<Integer>> graph, Set<Integer> seen, int a, int b, int prev) {
        if (a == b) {
            return true;
        }
        if (seen.contains(a)) {
            return false;
        }
        seen.add(a);
        for (int nei: graph.get(a)) {
            if (nei == prev) continue;
            if (isConnected(graph, seen, nei, b, a)) {
                return true;
            }
        }
        return false;
    }
    public void build(int[][] edges, Map<Integer, List<Integer>> graph ) {
        for (int i = 1; i <= edges.length; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e: edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
    }
}
