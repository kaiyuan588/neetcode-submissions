class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0) {
            return new int[][]{};
        }
        PriorityQueue<int[]> max = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (cal(a) > cal(b)) {
                    return -1;
                }
                return cal(a) < cal(b) ? 1 : 0;
            }
        });

        for (int i = 0; i < points.length; i++) {
            if (max.size() < k) {
                max.offer(points[i]);
            } else {
                if (cal(max.peek()) > cal(points[i])) {
                    max.poll();
                    max.offer(points[i]);
                }
            }
        }
        int[][] res = new int[max.size()][2];
        int i = 0;
        while (!max.isEmpty()) {
            res[i++] = max.poll(); 
        }
        return res;
    }

    public double cal(int[] point) {
        return Math.sqrt((point[0] - 0) * (point[0] - 0) + (point[1] - 0) * (point[1] - 0));
    }
}
