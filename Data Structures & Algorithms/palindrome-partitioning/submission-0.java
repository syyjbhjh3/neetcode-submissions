class Solution {
    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> current = new ArrayList<>();
        dfs(s, 0, current);
        return answer;    
    }

    private void dfs(String s, int start, List<String> current) {
        if (s.length() == start) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int i=start; i<s.length(); i++) {
            String sub = s.substring(start, i + 1);

            if(isPalindrome(sub)) {
                current.add(sub);
                dfs(s, i+1, current);
                current.remove(current.size()-1);
            }
        }
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length()-1;

        while (left < right) {
            if(word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
