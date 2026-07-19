/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val < n2.val) return -1;
                return n1.val > n2.val ? 1 : 0;
            }
        });

        for (ListNode list: lists) {
            if (list == null) continue;
            minHeap.offer(list);
        }
        while (!minHeap.isEmpty()) {
            ListNode tmp = minHeap.poll();
            cur.next = tmp;
            cur = cur.next;
            tmp = tmp.next;
            if (tmp != null) {
                minHeap.offer(tmp);
            }
        }
        return dummy.next;
    }
}
