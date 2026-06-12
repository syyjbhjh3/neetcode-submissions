class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<Integer> current = new ArrayList<>();
        dfs(nums, 0, current);
        return answer;    
    }

    private void dfs(int[] nums, int start, List<Integer> current) {
        answer.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // [💥 핵심 수정 3] 중복된 숫자로 시작하는 가지는 쳐내기!
            // 현재 선택할 수 있는 범위(start) 안에서, 바로 직전 숫자와 똑같은 숫자가 또 나오면
            // 어차피 똑같은 조합들이 똑같이 만들어지므로 그냥 건너뜁니다.
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            dfs(nums, i + 1, current);
            current.remove(current.size() - 1); // 지우개 마법 🪄
        }
    }
}