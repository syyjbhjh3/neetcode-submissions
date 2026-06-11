class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] answer = new int[k][2];

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distA, distB); 
        });

        for (int[] point : points){
            q.offer(point);
        }

        for (int i=0; i<k; i++){
            answer[i] = q.poll();
        }

        return answer;
    }
}
