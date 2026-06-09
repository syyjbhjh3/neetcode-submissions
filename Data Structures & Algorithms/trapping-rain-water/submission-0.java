class Solution {
    public int trap(int[] height) {
        // 투포인터 순회, 왼쪽 최고 높이 / 오른쪽 최고 높이를 구한다
        // 각 row의 빗물은 왼쪽 최고높이 오른쪽 최고높이의 작은 값의 - height[i]
        int rightMax = 0, leftMax = 0;
        int start = 0, end = height.length-1;
        int answer = 0;

        while(start < end) {
            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax, height[end]);

            if(height[start] <= height[end]) {
                answer += Math.min(leftMax, rightMax) - height[start];
                start++;
            } else {
                answer += Math.min(leftMax, rightMax) - height[end];
                end--;
            }
        }
        
        return answer;
    }
}
