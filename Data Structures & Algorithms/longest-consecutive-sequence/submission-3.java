class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);

        int continues = 1;
        int max = 0;

        if (nums.length == 0) return max;
        if (nums.length == 1) return continues;

        for (int i=0; i<nums.length-1; i++) {
            if (nums[i+1] - nums[i] == 1) continues++;
            if (nums[i+1] - nums[i] == 0) continue;
            if (nums[i+1] - nums[i] > 1) continues=1;

            max = Math.max(max, continues);
        }

        return Math.max(max, continues);
    }
}
