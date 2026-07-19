class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        char[][] grid = new char[n][n];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = '.';
            }
        }
        dfs(grid, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(char[][] grid, int i, List<String> path, List<List<String>> res) {
        if (i == grid.length) {
            res.add(new ArrayList<>(path));
            return ;
        }
        for (int c = 0; c < grid[0].length; c++) {
            if (isValid(grid, i, c)) {
                grid[i][c] = 'Q';
                path.add(new String(grid[i]));
                dfs(grid, i+1, path, res);
                grid[i][c] = '.';
                path.remove(path.size() - 1);
            }

        }
    }
    public boolean isValid(char[][] grid, int i, int j) {
        // CHECK ROW
        for (int r = 0; r < grid[i].length; r++) {
            if (r == j) continue;
            if (grid[i][r] == 'Q') {
                return false;
            } 
        }
        // CHECK COL
        for (int c = 0; c < grid.length; c++) {
            if (c == i) continue;
            if (grid[c][j] == 'Q') {
                return false;
            }
        }
        // CHECK DIAG
        int curI = i-1;
        int curJ = j-1;
        while (curI >= 0 && curJ >= 0) {
            if (grid[curI][curJ] == 'Q') {
                return false;
            }
            curI--;
            curJ--;
        }
        curI = i-1;
        curJ = j+1;
        while (curI >= 0 && curJ < grid[0].length) {
            if (grid[curI][curJ] == 'Q') {
                return false;
            }
            curI--;
            curJ++;
        }
        return true;
    }
}

// .q.. (0,1)
// q... (1,0)
