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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = findKth(groupPrev, k);
            if (kth == null) break;
            ListNode groupNext = kth.next;

            ListNode cur = groupPrev.next;
            ListNode prev = groupNext;

            while (cur != groupNext) {
                ListNode nextNode = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nextNode;
            }

            // reconnect
            ListNode oldGroupHead = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = oldGroupHead;
        }

        return dummy.next;
    }

    public ListNode findKth(ListNode start, int k) {
        while (start != null && k != 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}
