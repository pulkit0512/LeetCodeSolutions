class Solution {
    int ans;
    public int totalNQueens(int n) {
        ans = 0;
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        getBoard(board, 0);
        return ans;
    }
    
    private void getBoard(char[][] board, int row) {
        if(row==board.length){
            ans++;
            return;
        }
        for(int i=0;i<board[0].length;i++){
            if(board[row][i]=='.' && isValid(board, row, i)){
                board[row][i] = 'Q';
                getBoard(board, row+1);
                board[row][i] = '.';
            }
        }
    }
    private boolean isValid(char[][] board, int row, int col){
        for(int i=0;i<board.length;i++){
            if(board[row][i]=='Q'){
                return false;
            }
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1, j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1, j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row+1, j=col-1;i<board.length && j>=0;i++,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row+1, j=col+1;i<board.length && j<board.length;i++,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}