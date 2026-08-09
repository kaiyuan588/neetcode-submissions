class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                if (stack.isEmpty() || stack.pollLast() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pollLast() != '{') {
                    return false;
                }
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pollLast() != '(') {
                    return false;
                }
            } else {
                stack.offerLast(c);
            }
        }
        return stack.isEmpty();
    }
}
