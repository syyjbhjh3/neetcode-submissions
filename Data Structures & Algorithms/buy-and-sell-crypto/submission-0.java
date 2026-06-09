class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0, minPrice = prices[0];

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            answer = Math.max(answer, price-minPrice);  
        }

        return answer;
    }
}
