class MinStack {
    Stack<Integer> stack;
    List<Integer> sort;

    public MinStack() {
        stack = new Stack<>();
        sort = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.push(val);
        sort.add(val);
    }
    
    public void pop() {
        sort.remove(stack.pop());
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        Collections.sort(sort);
        return sort.get(0);
    }
}
