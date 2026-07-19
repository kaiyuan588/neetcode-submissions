class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        if (heights == null || m == 0) return res;

        Set<String> pacific = new HashSet<>();
        Set<String> atlantic = new HashSet<>();

        for (int c = 0; c < n; c++) {
            dfs(heights, 0, c, heights[0][c], pacific);
            dfs(heights, m-1, c, heights[m-1][c], atlantic);
        }

        for (int r = 0; r < m; r++) {
            dfs(heights, r, 0, heights[r][0], pacific);
            dfs(heights, r, n-1, heights[r][n-1], atlantic);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String s = i + "-" + j;
                if (pacific.contains(s) && atlantic.contains(s)) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
    public void dfs(int[][] heights, int r, int c, int preHeight, Set<String> visited) {
        String s = r + "-" + c;
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || visited.contains(s) || heights[r][c] < preHeight) {
            return;
        }
        visited.add(s);
        dfs(heights, r+1, c,  heights[r][c], visited);
        dfs(heights, r-1, c,  heights[r][c], visited);
        dfs(heights, r, c+1,  heights[r][c], visited);
        dfs(heights, r, c-1,  heights[r][c], visited);
    }
}
