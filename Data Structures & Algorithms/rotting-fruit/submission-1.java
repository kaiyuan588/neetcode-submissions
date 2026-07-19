class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) { // rotten
                    q.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) { // fresh
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0}, {-1,0}};
        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int[] dir: dirs) {
                    int newX = cur[0] + dir[0];
                    int newY = cur[1] + dir[1];
                    if (newX < 0 || newY < 0 || newX >= n || newY >= m || grid[newX][newY] == 2) {
                        continue;
                    }
                    if (grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        fresh--;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
