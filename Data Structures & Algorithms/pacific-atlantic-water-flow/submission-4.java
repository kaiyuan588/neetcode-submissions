class Solution {
    public int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        Queue<int[]> pacif = new LinkedList<>();
        Queue<int[]> atlan = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pacif.offer(new int[]{i, 0});
            pacific[i][0] = true;
            atlan.offer(new int[]{i, n-1});
            atlantic[i][n-1] = true;
        }
        for (int j = 0; j < n; j++) {
            pacif.offer(new int[]{0, j});
            pacific[0][j] = true;
            atlan.offer(new int[]{m-1, j});
            atlantic[m-1][j] = true;
        }
        bfs(heights, pacif, m, n, pacific);
        bfs(heights, atlan, m, n, atlantic);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
    public void bfs(int[][] heights, Queue<int[]> q, int m, int n, boolean[][] visited) {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir: dirs) {
                int newx = dir[0] + cur[0];
                int newy = dir[1] + cur[1];
                if (newx >= 0 && newy >= 0 && newx < m && newy < n && heights[newx][newy] >= heights[cur[0]][cur[1]] && !visited[newx][newy]) {
                    q.offer(new int[]{newx, newy});
                    visited[newx][newy] = true;
                }
            }
        }
    }
}
