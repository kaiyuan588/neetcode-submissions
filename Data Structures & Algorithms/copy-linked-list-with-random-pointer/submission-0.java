/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> pair = new HashMap<>();
        Node cur = head;

        while (cur != null) {
            pair.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            pair.get(cur).random = pair.get(cur.random);
            pair.get(cur).next = pair.get(cur.next);
            cur = cur.next;
        }
        return pair.get(head);
    }
}
