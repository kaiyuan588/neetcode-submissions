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
        int min = minStack.peekLast();
        int val = stack.peekLast();
        if (min == val) {
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


