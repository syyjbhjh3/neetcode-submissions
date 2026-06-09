class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int start = 0, end = numbers.length-1;

        while(start < end) {
            int sum = numbers[start]+ numbers[end];
            if (sum == target) return new int[]{start+1, end+1};

            if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return answer;
    }
}
