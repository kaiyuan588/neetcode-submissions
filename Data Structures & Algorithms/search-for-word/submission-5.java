class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {

        boolean[][] seen = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    seen[i][j] = true;
                    if (dfs(board, i, j, 1, seen, word)) {
                        return true;
                    }
                    seen[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int index, boolean[][] seen, String word) {
        if (index == word.length()) {
            return true;
        }
        for (int[] dir: dirs) {
            int newx = dir[0] + i;
            int newy = dir[1] + j;
            if (newx < 0 || newy < 0 || newx >= board.length || newy >= board[0].length || seen[newx][newy]) {
                continue;
            }
            seen[newx][newy] = true;
            if (board[newx][newy] == word.charAt(index) && dfs(board, newx, newy, index+1, seen, word)) {
                return true;
            }
            seen[newx][newy] = false;
        }
        return false;
    }
}
