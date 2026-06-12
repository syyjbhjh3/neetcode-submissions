class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {    
        List<Integer> current = new ArrayList<>();

        dfs(nums, 0, target, current, 0);
        return answer;
    }

    private void dfs(int[] nums, int start, int target, List<Integer> current, int sum) {
        if (sum == target) {
            answer.add(new ArrayList<>(current));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]); 
            
            dfs(nums, i, target, current, sum + nums[i]); 
            
            current.remove(current.size() - 1); 
        }
    }
}