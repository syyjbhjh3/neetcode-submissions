class Solution {
    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        int nonZerSum = 1;

        int[] answer = new int[nums.length];
        int zeroCnt = 0;

        for (int num : nums) {
            if (num == 0) {
              zeroCnt++;  
            } else {
              sum *= num;
            }
        }

        
        if (zeroCnt > 1) {
            return answer;
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                answer[i] = sum;
            } else if(zeroCnt==1) {
                answer[i] = 0;
            } else {
                answer[i] = sum/nums[i];
            }
        }       
        return answer;
    }
}  
