class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Character> boxSet = new HashMap<>();
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    int boxIndex = (i / 3 * 3) + (j / 3);
                    if (boxSet.containsKey(boxIndex)) {
                        if (boxSet.get(boxIndex) == board[i][j]) {
                            return false;
                        }
                    } else {
                        boxSet.put(boxIndex, board[i][j]);
                    }
                    if (rowSet[i].contains(board[i][j])) return false;
                    if (colSet[j].contains(board[i][j])) return false;
                    rowSet[i].add(board[i][j]);
                    colSet[j].add(board[i][j]);
                }
            }
        }
        return true;
    }
}
