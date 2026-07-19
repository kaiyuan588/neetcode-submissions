class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Set<String> seen = new HashSet<>();

        for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') {
                // run dfs
                dfs(board, 0, c, seen);
            }
            if (board[m-1][c] == 'O') {
                // run dfs
                dfs(board, m-1, c, seen);
            }
        }
        for (int r = 0; r < m; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0, seen);
            }
            if (board[r][n-1] == 'O') {
                dfs(board, r, n-1, seen);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String s = i + "-" + j;
                if (!seen.contains(s) && board[i][j] == 'O') {
                    board[i][j] = 'X';
                } 
            }
        }
    }

    public void dfs(char[][] board, int r, int c, Set<String> seen) {
        String s = r + "-" + c;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || seen.contains(s) || board[r][c] == 'X') {
            return;
        }
        seen.add(s);

        dfs(board, r+1, c, seen);
        dfs(board, r-1, c, seen);
        dfs(board, r, c+1, seen);
        dfs(board, r, c-1, seen);

    }
}
