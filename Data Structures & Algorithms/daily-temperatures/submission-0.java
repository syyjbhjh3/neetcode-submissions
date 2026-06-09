class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        
        for(int i=0; i<temperatures.length; i++){
            int count = 1;
            int j = i+1;
            while (j < temperatures.length) {
                if (temperatures[i] < temperatures[j]) {
                    break;
                }
                j++;
                count++;
            }

            if (j==temperatures.length) {
                count = 0;
            }
            
            answer[i] = count;
        }
        
        return answer;
    }
}
