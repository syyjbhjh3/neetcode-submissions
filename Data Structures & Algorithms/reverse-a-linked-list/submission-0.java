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
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;

        Stack<Integer> stack = new Stack();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!stack.empty()) {
            current.next = new ListNode(stack.pop());
            current = current.next;
        }

        return dummy.next;
    }
}
