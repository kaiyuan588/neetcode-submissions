class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length == 0) return new int[][]{};

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (cal(a) > cal(b)) {
                    return -1;
                }
                return cal(a) < cal(b) ? 1 : 0;
            }
        });

        for (int[] point: points) {
            if (maxHeap.size() != k) {
                maxHeap.offer(point);
            } else {
                if (cal(point) < cal(maxHeap.peek())) {
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }
        int[][] res = new int[maxHeap.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
    public double cal(int[] a) {
        return Math.sqrt(
            (a[0] * a[0] + a[1] * a[1])
            );
    }
}
