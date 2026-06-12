class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> current = new ArrayList<>();
        dfs(0, nums, current);
        return answer;
    }

    private void dfs(int start, int[] nums, List<Integer> current) {
        answer.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            
            dfs(i + 1, nums, current); 
            
            current.remove(current.size() - 1);
        }
    }
}