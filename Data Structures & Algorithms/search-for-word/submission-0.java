class Solution {
    private static final int[][] DIRECTIONS = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, row, col, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(
            char[][] board,
            int row,
            int col,
            String word,
            int index
    ) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0
                || row >= rows
                || col < 0
                || col >= cols
                || board[row][col] == '#'
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        char originalCharacter = board[row][col];
        board[row][col] = '#';

        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (dfs(board, nextRow, nextCol, word, index + 1)) {
                board[row][col] = originalCharacter;
                return true;
            }
        }

        board[row][col] = originalCharacter;
        return false;
    }
}