class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int answer = 0, left = 0;

        char[] cs = s.toCharArray();
        
        for(int right=0; right<cs.length; right++) {
            char c = cs[right];

            while (set.contains(c)) {
                set.remove(cs[left]);
                left++;
            }

            set.add(c);

            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}
