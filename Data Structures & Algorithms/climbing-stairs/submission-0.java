class Solution {
    public int climbStairs(int n) {
        // 1과 2만을 사용해서 n을 만들 수 있는 경우의 수를 구하라
            // 3의 경우 [1 1 1] [1 2] [2 1] 3
            // 4의 경우 [1 1 1 1] [2 1 1] [1 2 1] [1 1 2] [2 2] 5
            // 5의 경우 [1 1 1 1 1] [2 1 1 1] []

        //1은 n은 45까지이기에 1이라면 1을 return
        if (n <= 2) return n;

        // dp[n] = dp[n-1] + dp[n-2];
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
