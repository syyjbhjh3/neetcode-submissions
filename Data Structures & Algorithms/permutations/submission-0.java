class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();

        getPermutations(nums, current, visited);
        return answer;
    }

    private void getPermutations(int[] nums, List<Integer> current, boolean[] visited){
        if (current.size() == nums.length) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                current.add(nums[i]);
                visited[i] = true;
                getPermutations(nums, current, visited);
                visited[i] = false;
                current.remove(current.size()-1);
            }
        }
    }
}
