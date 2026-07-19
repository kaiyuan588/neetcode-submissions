class MinStack {
    Deque<Node> stack = new ArrayDeque<>();

    public MinStack() {

    }
    
    public void push(int val) {
        int curMin = stack.isEmpty() ? val : Math.min(stack.peekLast().min, val);
        stack.offerLast(new Node(val, curMin));
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pollLast();
        }
    }
    
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peekLast().val;
        }
        return -1;
    }
    
    public int getMin() {
        if (!stack.isEmpty()) {
            return stack.peekLast().min;
        }        
        return -1;
    }
}

class Node {
    int val;
    int min;
    Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
