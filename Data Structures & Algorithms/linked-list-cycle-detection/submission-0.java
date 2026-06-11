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

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head; 
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // 거북이 1칸 전진
            fast = fast.next.next;      // 토끼 2칸 전진

            if (slow == fast) {
                return true; // 토끼가 한 바퀴 따라잡았으니 순환 있음!
            }
        }

        return false;
    }
}