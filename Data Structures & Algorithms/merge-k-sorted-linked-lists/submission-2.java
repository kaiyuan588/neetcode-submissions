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
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> min = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val < l2.val) {
                    return -1;
                }
                return l1.val > l2.val ? 1 : 0;
            }
        });
        for (ListNode list: lists) {
            min.offer(list);
        }
        ListNode res = new ListNode(-1);
        ListNode cur = res;

        while (!min.isEmpty()) {
            ListNode smallest = min.poll();
            cur.next = smallest;
            if (smallest.next != null) {
                smallest = smallest.next;
                min.offer(smallest);
            }
            cur = cur.next;
        }
        return res.next;
    }
}
