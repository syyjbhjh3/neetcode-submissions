class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. 전체 노드의 개수(size) 구하기
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        // 뒤에서 n번째 = 앞에서부터 몇 번 전진해야 하는지 계산
        int removeIndex = size - n;

        // [예외 처리] 만약 맨 첫 번째 노드(head)를 지워야 하는 경우라면?
        // 그냥 지금 head의 다음 노드를 새로운 head로 리턴하면 끝납니다!
        if (removeIndex == 0) {
            return head.next;
        }

        // 2. 삭제할 노드의 '바로 앞 노드'까지 이동하기
        // 원래 head 위치를 잃어버리지 않기 위해 dummy(임시) 포인터를 씁니다.
        ListNode prev = head;
        for (int i = 0; i < removeIndex - 1; i++) {
            prev = prev.next;
        }

        // 3. 징검다리 건너뛰기 (삭제 로직)
        // prev의 다음 노드(지울 노드)를 건너뛰고, 그 다음다음 노드를 가리키게 합니다.
        prev.next = prev.next.next;

        // 처음에 잘 보존해둔 시작점(head)을 리턴합니다.
        return head;
    }
}