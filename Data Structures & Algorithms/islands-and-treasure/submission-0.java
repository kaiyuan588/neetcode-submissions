class Solution {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return ;
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) { // the treasure
                    q.offer(new int[]{i,j});
                }
            }
        }
        bfs(grid, q);
    }

    public void bfs(int[][] grid, Queue<int[]> q) {
        int len = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int[] dir: dirs) {
                    int newX = cur[0]+dir[0];
                    int newY = cur[1]+dir[1];
                    if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length || grid[newX][newY] == 0 || grid[newX][newY] == -1) {
                        continue;
                    }
                    if (grid[newX][newY] == Integer.MAX_VALUE) {
                        grid[newX][newY] = len+1;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
            len++;
        }
    }
}
