class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, 1, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, int i, int j, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        char saved = board[i][j];
        board[i][j] = '#';
        for (int[] dir: dirs) {
            int newx = dir[0] + i;
            int newy = dir[1] + j;
            if (newx < 0 || newy < 0 || newx >= board.length || newy >= board[0].length || board[newx][newy] != word.charAt(index)) {
                continue;
            }
            if (dfs(board, dir[0] + i, dir[1] + j, index + 1, word)) {
                return true;
            }
        }
        board[i][j] = saved;
        return false;
    }
}
