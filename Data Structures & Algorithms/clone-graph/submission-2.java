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
        return dfs(node, copy);
    }
    public Node dfs(Node node, Map<Node, Node> copy) {
        if (copy.containsKey(node)) {
            return copy.get(node);
        }
        Node newNode = new Node(node.val);
        copy.put(node, newNode);

        for (Node nei: node.neighbors) {
            newNode.neighbors.add(dfs(nei, copy));
        }
        return newNode;
    }
}