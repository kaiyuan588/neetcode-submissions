class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> res = new ArrayList<>();
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i]; 
            // if cur interval is on the left of the newInterval
            if (cur[1] < newInterval[0]) {
                res.add(cur);
            } else if (newInterval[1] < cur[0]) {
                if (!inserted) {
                    res.add(newInterval);
                    inserted = true;
                }
                res.add(cur);
            } else {
                newInterval = new int[]{Math.min(cur[0], newInterval[0]), Math.max(cur[1], newInterval[1])};

            }
            // if the cur interval and new Interval has overlap
            // [a,b] [c,d]
            // not overlap b > c || d < a (b <= c && d >= a)

            // the the cur interval is on the right of the newInterval

        }

        if (!inserted) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }
}
