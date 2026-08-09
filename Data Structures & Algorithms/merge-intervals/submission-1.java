class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) {
                    return -1;
                }
                return a[0] > b[0] ? 1 : 0;
            }
        });

        List<int[]> res = new ArrayList<>();

        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size()-1);
            int[] cur = intervals[i];
            if (last[1] >= cur[0]) {
                int[] newInter = new int[]{last[0], Math.max(last[1], cur[1])};
                res.set(res.size()-1, newInter);
            } else {
                res.add(cur);
            }
        }
        int[][] output = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            output[i] = res.get(i);
        }

        return output;
    }
}
