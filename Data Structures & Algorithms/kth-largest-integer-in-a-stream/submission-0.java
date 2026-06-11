
class KthLargest {
    private PriorityQueue<Integer> queue;
    private int k; // k값을 전역적으로 기억하기 위한 변수

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        this.k = k; // 전역 변수에 k 저장
        
        // 처음에 주어지는 배열의 숫자들을 일단 다 넣습니다.
        for (int num : nums) {
            add(num); // 아래 구현한 add 메서드를 재사용하면 편해요!
        }
    }
    
    public int add(int val) {
        queue.add(val); // 1. 일단 새로운 숫자를 무조건 넣는다.
        
        // 2. 만약 큐에 담긴 숫자가 k개보다 많아졌다면?
        // 가장 작은 녀석(맨 위)은 상위 k등 안에 못 드는 녀석이므로 버립니다.
        if (queue.size() > k) {
            queue.poll(); 
        }
        
        // 3. 이제 큐에는 딱 k개의 '가장 큰 숫자들'만 남아있습니다.
        // 그중에서 "가장 작은 녀석"이 곧 전체에서 딱 k번째로 큰 숫자가 됩니다!
        return queue.peek(); 
    }
}