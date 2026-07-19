class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> g = new HashMap<>();
        build(tickets, g);

        List<String> path = new ArrayList<>();
        dfs(g,"JFK", path);
        Collections.reverse(path);
        return path;
    }

    public void dfs(Map<String, List<String>> g, String cur, List<String> path) {
        List<String> neis = g.get(cur);
        while (neis != null && neis.size() != 0) {
            Collections.sort(neis);
            String next = neis.remove(0);
            dfs(g, next, path);
        }

        path.add(cur);

    }

    // HOU [JFK]
    // SEA [JFK]
    // JFK [SEA, HOU]


    public List<String> find(Map<String, List<String>> g, String cur) {
        Stack<String> stack = new Stack<>();
        stack.push(cur);

        List<String> path = new ArrayList<>();
        while (!stack.isEmpty()) {
            String top = stack.peek();
            List<String> neis = g.get(top); // get the reference

            if (neis == null || neis.size() == 0) {
                path.add(stack.pop());
            } else {
                Collections.sort(neis);
                String nei = neis.remove(0);
                stack.push(nei);
            }
        }
        Collections.reverse(path);
        return path;
    }
    public void build(List<List<String>> tickets, Map<String, List<String>> g) {
        for (List<String> list: tickets) {
            String from = list.get(0);
            String to = list.get(1);
            if (!g.containsKey(from)) {
                g.put(from, new ArrayList<>());
            }
            g.get(from).add(to);
        }
    }
}
