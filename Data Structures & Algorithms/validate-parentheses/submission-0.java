class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        Deque<Character> stack = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            if (c == '}') {
                if (!stack.isEmpty() && stack.peekLast() == '{') {
                    stack.pollLast();
                } else {
                    return false;
                }
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peekLast() == '[') {
                    stack.pollLast();
                } else {
                    return false;
                }
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peekLast() == '(') {
                    stack.pollLast();
                } else {
                    return false;
                }
            } else {
                stack.offerLast(c);
            }
        }
        return stack.isEmpty();
    }
}
// {[((((()))))]}


