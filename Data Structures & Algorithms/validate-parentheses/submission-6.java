class Solution {
    public boolean isValid(String s) {
        boolean answer = true;

        if (s.length() % 2 == 1) return false;

        Stack<Character> braket = new Stack<>();
        char[] cs = s.toCharArray();

        for(char c : cs){
            if (c == '(' || c == '{' || c == '['){
                braket.push(c);
            } else if(braket.empty()) {
                return false;
            } else if (c == ')') {
                if(braket.pop() != '(') return false;    
            } else if (c == '}') {
                if(braket.pop() != '{') return false;    
            } else if (c == ']') {
                if(braket.pop() != '[') return false;    
            }
        }

        return braket.empty();
    }
}
