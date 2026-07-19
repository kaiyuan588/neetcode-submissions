class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        for (String str: tokens) {
            if (str.equals("+")) {
                int first = stack.pollLast();
                int second = stack.pollLast();
                stack.offerLast(first+second);
            } else if (str.equals("-")) {
                int first = stack.pollLast();
                int second = stack.pollLast();
                stack.offerLast(second-first);
            } else if (str.equals("*")) {
                int first = stack.pollLast();
                int second = stack.pollLast();
                stack.offerLast(first*second);
            } else if (str.equals("/")) {
                int first = stack.pollLast();
                int second = stack.pollLast();
                stack.offerLast(second/first);
            } else {
                stack.offerLast(Integer.parseInt(str));
            }
        }
        return stack.peekLast();
    }
}
