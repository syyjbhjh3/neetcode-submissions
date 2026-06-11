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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1 == null && l2 == null) return null;

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        int num = 0;

        while(l1 != null || l2 != null) {
            int sum = 0;

            if (l1 == null) {
                sum = l2.val + num;
                l2 = l2.next;
            } else if (l2 == null) {
                sum = l1.val + num;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + num;
                l1 = l1.next;
                l2 = l2.next;
            }

            num = 0;

            if (sum >= 10) {
                num = 1;
                sum = sum-10;
            }

            current.next = new ListNode(sum);
            current = current.next;

        }

        if (num > 0) {
            current.next = new ListNode(num);
        }

        return dummy.next;
    }
}
