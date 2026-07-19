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
        Map<Node, Node> map = new HashMap<>();
        if (node == null) return null;

        dfs(node, map);
        return map.get(node);
    }
    public Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        List<Node> neis = node.neighbors;
        for (Node nei: neis) {
            newNode.neighbors.add(dfs(nei, map));
        }
        return newNode;
    }
}