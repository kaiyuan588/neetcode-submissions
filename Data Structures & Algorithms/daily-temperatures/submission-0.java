class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[]{};

        Deque<Integer> decrease = new ArrayDeque<>();
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = n-1; i >= 0; i--) {
            if (decrease.isEmpty()) {
                decrease.offerLast(i);
                res[i] = 0;
            } else {
                while (!decrease.isEmpty() && temperatures[i] >= temperatures[decrease.peekLast()]) {
                    decrease.pollLast();
                } 
                if (decrease.isEmpty()) {
                    res[i] = 0;
                } else {
                    res[i] = decrease.peekLast() - i;
                }
                decrease.offerLast(i);
            }
        }
        return res;
    }
}

//   35 40
