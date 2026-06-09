class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 3개의 합이 0되는 걸 찾기, 중복 X
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        // 1개 고정
        for (int i=0; i<nums.length-2; i++) {

            int start = i+1, end = nums.length-1;

            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == 0) {
                    if (!answer.contains((Arrays.asList(nums[i], nums[start], nums[end])))) {
                        answer.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    }
                    start++;
                    end--;
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
            
        }         

        return answer;
    }
}
