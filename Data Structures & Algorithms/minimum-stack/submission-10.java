class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.offerLast(val);
        if (minStack.isEmpty()) {
            minStack.offer(val);
        } else {
            if (val <= minStack.peekLast()) {
                minStack.offer(val);
            }
        }
    }
    
    public void pop() {
        if (minStack.peekLast().equals(stack.peekLast())) {
            minStack.pollLast();
            stack.pollLast();
        } else {
            stack.pollLast();
        }
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
    }
}


