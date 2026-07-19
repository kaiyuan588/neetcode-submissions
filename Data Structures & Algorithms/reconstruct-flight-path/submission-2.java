class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) return res;
        Map<String, List<String>> g = new HashMap<>();
        build(tickets, g);

        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {  
            String cur = stack.peek();
            List<String> neis = g.get(cur);
            
            if (neis == null || neis.size() == 0) {
                res.add(stack.pop());
            } else {
                Collections.sort(neis);
                stack.push(neis.remove(0));
            }
        }
        Collections.reverse(res);
        return res;
    }

    public void build(List<List<String>> tickets, Map<String, List<String>> g) {
        for (List<String> str: tickets) {
            String from = str.get(0);
            String to = str.get(1);
            if (!g.containsKey(from)) {
                g.put(from, new ArrayList<>());
            }
            g.get(from).add(to);
        }
    }
}
