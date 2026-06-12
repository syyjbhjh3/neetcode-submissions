class Solution {
    List<String> answer = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;
        String current = "";

        dfs(open, close, current, n);
        return answer;
    }

    private void dfs(int open, int close, String current, int n) {
        if (current.length() == n * 2) {
            answer.add(current); 
            return;
        }

        if (open > 0) {
            dfs(open - 1, close, current + "(", n);
        }

        if (close > open) {
            dfs(open, close - 1, current + ")", n);
        }
    }
}