

class Solution {
    public int lastStoneWeight(int[] stones) {
        // Collections.reverseOrder()를 넣어 가장 큰 값(무거운 돌)부터 나오도록 설정 (Max-Heap)
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) q.offer(stone);

        // 돌이 2개 이상 남아있을 때만 부딪힐 수 있습니다.
        while (q.size() > 1) {
            int stone1 = q.poll(); // 가장 무거운 돌
            int stone2 = q.poll(); // 두 번째로 무거운 돌

            // 두 돌의 무게가 다르면, 남은 파편을 다시 큐에 넣습니다.
            if (stone1 != stone2) {
                q.offer(stone1 - stone2);
            }
        }

        // 큐가 비어있으면 모든 돌이 깨진 것이므로 0, 남아있으면 그 돌의 무게 반환
        return q.isEmpty() ? 0 : q.peek();
    }
}