class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {

        boolean[][] seen = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, 0, seen, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int index, boolean[][] seen, String word) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || seen[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length()-1) {
            return true;
        }
        seen[i][j] = true;
        for (int[] dir: dirs) {
            int newx = dir[0] + i;
            int newy = dir[1] + j;
            if (dfs(board, newx, newy, index+1, seen, word)) {
                return true;
            }
        }
        seen[i][j] = false;
        return false;
    }
}
