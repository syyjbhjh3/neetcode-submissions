class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 1. 탐색 범위 정의 (최소 속도는 1, 최대 속도는 가장 큰 더미의 바나나 수)
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile); // 굳이 정렬 안 해도 최댓값만 찾으면 됩니다!
        }

        int answer = right;

        // 2. 이진 탐색 시작
        while (left <= right) {
            int mid = left + (right - left) / 2; // 말씀하신 '중간 요소' (속도 K)
            long totalHours = 0;

            // 중간값(mid) 속도로 먹었을 때 걸리는 총 시간 계산
            for (int pile : piles) {
                totalHours += (int) Math.ceil((double) pile / mid);
            }

            // 3. 조건 부합 확인 및 범위 축소
            if (totalHours <= h) {
                // h 시간 안에 다 먹을 수 있다면? -> "더 천천히 먹을 수 있나?" 확인 위해 왼쪽 절반 탐색
                answer = mid; // 우선 현재 속도를 정답 후보로 저장
                right = mid - 1; 
            } else {
                // h 시간 안에 다 못 먹는다면? -> "더 빨리 먹어야 하네!" 오른쪽 절반 탐색
                left = mid + 1;
            }
        }

        return answer;
    }
}