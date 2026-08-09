class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekLast()]) {
                System.out.println(stack.peekLast() + " " + i);
                res[stack.peekLast()] = i - stack.peekLast();
                stack.pollLast();
            }
            stack.offerLast(i);
        }
        return res;
    }
}


// 30 30 38

// 0 