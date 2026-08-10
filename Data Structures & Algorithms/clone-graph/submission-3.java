/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> copy = new HashMap<>(); // original to copy
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        copy.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node nei: cur.neighbors) {
                if (!copy.containsKey(nei)) {
                    Node newNode = new Node(nei.val);
                    copy.put(nei, newNode);
                    q.offer(nei);
                }
                copy.get(cur).neighbors.add(copy.get(nei));
            }
        }
        return copy.get(node);
    }
}