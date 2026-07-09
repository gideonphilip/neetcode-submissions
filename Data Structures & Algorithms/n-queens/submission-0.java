class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        backtrack(board, 0, result);
        return result;
    }
    private void backtrack(char[][] board, int row, List<List<String>> result){
        if(row == board.length){
            result.add(buildBoard(board));
            return;
        }

        for(int col=0; col<board.length; col++){
            if(!isSafe(board, row, col)){
                continue;
            }

            board[row][col] = 'Q';
            backtrack(board, row+1, result);
            board[row][col] = '.';
        }

    }

    private boolean isSafe(char[][] board, int row, int col){
        int n = board.length;

        for(int r = 0; r < row; r++){
            if(board[r][col] == 'Q'){
                return false;
            }
        }

        for(int r = row-1,c = col - 1; r>=0 && c>=0; r--,c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        for(int r=row-1, c=col+1; r>=0 && c<n; r--,c++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        return true;

    }

    private List<String> buildBoard(char[][] board){
        List<String> rows = new ArrayList<>();
        for(char[] row: board){
            rows.add(new String(row));
        }
        return rows;
    }
}
