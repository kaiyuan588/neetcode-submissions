class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length != speed.length) {
            return -1;
        }   
        int n = position.length;
        int[][] pair = new int[n][2];

        for (int i = 0; i < n; i++) {
            pair[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(a[0],b[0]));

        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = n-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.offerLast(pair[i]);
            } else {
                int[] lastEle = stack.peekLast();
                int[] curEle = pair[i];
                double lastEleTime = (double)(target - lastEle[0]) / lastEle[1];
                double curEleTime = (double)(target - curEle[0]) / curEle[1];

                if (curEleTime > lastEleTime) {
                    stack.offerLast(curEle);
                }
            }
        }
        return stack.size();
    }
}


// 4 1 0 7
// 2 2 1 1

// target = 10

// t = 3 4.5 10 3

//             5
