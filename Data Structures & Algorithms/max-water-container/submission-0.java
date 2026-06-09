class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int start = 0, end = heights.length-1;

        // 투포인터로 순회 
        while(start < end) {
            int row = end - start;
            int height = Math.min(heights[start], heights[end]);

            int sum = row * height;

            if (heights[start] > heights[end]) {
                end--;
            } else {
                start++;
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
