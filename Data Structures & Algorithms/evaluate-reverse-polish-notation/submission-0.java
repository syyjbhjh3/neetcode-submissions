class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); // 계산을 위해 Integer 스택으로 변경!

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int first = stack.pop();  // 스택 맨 위 (오른쪽 숫자)
                int second = stack.pop(); // 그 아래 (왼쪽 숫자)
                
                switch(token) {
                    case "+": stack.push(second + first); break;
                    case "-": stack.push(second - first); break;
                    case "*": stack.push(second * first); break;
                    case "/": stack.push(second / first); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}