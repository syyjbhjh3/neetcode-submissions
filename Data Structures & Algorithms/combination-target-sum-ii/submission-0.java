class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // [수정 1] 인풋 배열을 먼저 오름차순으로 정렬합니다!
        // 중복된 숫자들이 [1, 1, 2, 5, 6, 7, 10] 처럼 나란히 모이게 만듭니다.
        Arrays.sort(candidates);
        
        List<Integer> current = new ArrayList<>();

        dfs(candidates, 0, 0, target, current);
        return answer;
    }

    private void dfs(int[] candidates, int start, int sum, int target, List<Integer> current) {
        if (sum == target) {
            answer.add(new ArrayList<>(current));
            return;
        }

        if (sum > target) return;

        for (int i = start; i < candidates.length; i++) {
            // [💥 핵심 수정 3] 중복 조합 건너뛰기 (가지치기)
            // 내가 고를 수 있는 범위(start) 안에서, 방금 전(i - 1)에 썼던 숫자와 
            // 지금(i) 쓰려는 숫자가 똑같다면? 똑같은 조합이 복사되므로 넘겨버립니다(continue).
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            current.add(candidates[i]);
            
            dfs(candidates, i + 1, sum + candidates[i], target, current);
            
            current.remove(current.size() - 1);
        }
    }
}