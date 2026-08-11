class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } 
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
            }
        }
        
        int time = 0;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir: dirs) {
                    int newx = dir[0] + cur[0];
                    int newy = dir[1] + cur[1];
                    if (newx >= 0 && newy >= 0 && newx < m && newy < n && grid[newx][newy] == 1) {
                        grid[newx][newy] = 2;
                        q.offer(new int[]{newx, newy});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
