class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0; // 누적해서 주워 담을 주머니

        for (int num : nums) {
            // [그리디 핵심] 내 주머니가 마이너스(빚) 상태라면?
            // 들고 가봤자 손해니까 과감하게 버리고 0으로 리셋한다!
            if (currentSum < 0) {
                currentSum = 0;
            }

            // 현재 숫자를 주머니에 담음
            currentSum += num;

            // 지금까지의 주머니 금액 중 가장 컸던 순간을 기록
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
