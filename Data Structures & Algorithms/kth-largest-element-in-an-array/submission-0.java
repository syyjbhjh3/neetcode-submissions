class Solution {
    public int findKthLargest(int[] nums, int k) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int num : nums) {
           q.add(num);
        }

        for (int i=0; i<k; i++) {
            answer = q.poll();
        }

        return answer;
    }
}

